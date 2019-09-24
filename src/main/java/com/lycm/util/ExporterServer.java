package com.lycm.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lycm.dao.InfoMapper;


@Component

public class ExporterServer {
	@Autowired 
	InfoMapper infoMapper;
	@PostConstruct
	public void init() {

		int port = 20502;
		new Thread(()-> {
			
			try (ServerSocket serverSocket = new ServerSocket(port)) {

				System.out.println("Server is listening on port " + port);

				while (true) {
					Socket socket = serverSocket.accept();
					
					new ServerThread(socket,infoMapper).start();
				}

			} catch (IOException ex) {
				System.out.println("Server exception: " + ex.getMessage());
				ex.printStackTrace();
			}
			
		}).start();;

	}
}