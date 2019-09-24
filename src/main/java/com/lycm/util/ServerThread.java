package com.lycm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lycm.dao.InfoMapper;
import com.lycm.pojo.Info;

/**
 * This thread is responsible to handle client connection.
 *
 * @author www.codejava.net
 */
public class ServerThread extends Thread {
	private Logger logger = LoggerFactory.getLogger(ServerThread.class);
	private Socket socket;
	@Autowired 
	InfoMapper infoMapper;
	
	private BufferedReader read;
	public ServerThread(Socket socket, InfoMapper infoMapper) {
		this.socket = socket;
		this.infoMapper = infoMapper;
	}

	@Override
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			
			while (true) {
				String text = reader.readLine();
				if (text != null) {
					System.out.println(text);
					//进行数据解析(通过@的$符号来判断是哪个消息)
					//1:如果收到Pong,那么你这边就要返回AckPong
					//2:然后你要发Ping,收到AckPing
					//3:之后就可以GetInfo,然后就会收到多条提交数据的指令(AckGetInfo,Store)
					//4:正确处理之后,再返回AckStore
					//5:收到Marker之后,再返回AckMarker,就可以结束当前的通信了
					if(text.indexOf("@Pong@$")!=-1) {
						//writer.println("10 KM@AckPong@$");
						writer.println("Bag@Ping@Bag@AckPong@");
						writer.flush();
						writer.println("@GetInfo@$");
						writer.flush();
					} else if(text.indexOf("@Store@")!=-1) {
						text = text.substring(text.indexOf("@Store@")+7,text.lastIndexOf("@")-5);
						
						String[] array = text.split("@");
						for(int i = 0; i < array.length; i++) {
							Info info = new Info();
							info.setInfo(array[i].substring(0, 19));
							infoMapper.insert(info);
						}
						writer.println("@AckStore@");
						writer.flush();
					}//@Marker@ 
					else if(text.indexOf("@Marker@")!=-1) {
						break;
					}
                    
				} else {
					break;
				}
			}
			/*
			 * reader.close(); writer.close(); socket.close();
			 */
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
			try {
				socket.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
}