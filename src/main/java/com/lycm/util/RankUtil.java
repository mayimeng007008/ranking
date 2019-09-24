package com.lycm.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.lycm.dao.InfoMapper;
import com.lycm.dao.UserMapper;
import com.lycm.pojo.Info;
import com.lycm.pojo.User;
import com.lycm.vo.RankMan;
import com.lycm.vo.RankWoman;
import com.lycm.vo.RankingVo;

public class RankUtil {
	@Autowired
	InfoMapper infoMapper;
	@Autowired
	UserMapper userMapper;
	public void rankByTcp() {
		//创建集合用于封装信息
				Map mapMan= new HashMap<>();
				Map mapWoman = new HashMap<>();
				RankingVo rankingVo = new RankingVo();
				List<RankMan> list1 = new ArrayList();
				List<RankWoman> list2 = new ArrayList();
				//获取所有信息
				List<Info> list = infoMapper.findAll();
			//System.out.println(list);
				//遍历截取信息
				for (int i = 0; i < list.size(); i++) {
					Info info = list.get(i);
					//编号
				String number =	info.getInfo().substring(0,7);
				//System.out.println(number);
					//时
				String timeHH =info.getInfo().substring(7, 9);
				//System.out.println(timeHH);
					//分
				String timeMM =info.getInfo().substring(10,12);
					//秒
				String timeSS =info.getInfo().substring(13,15);
				//转化为秒数，用于排序
				//long times=11111;
			long times = Integer.valueOf(timeHH)*3600+Integer.valueOf(timeMM)*60+Integer.valueOf(timeSS);
				//根据标号查找对应人员信息
				User user = userMapper.findByNumber(number);
					//分别封装到男，女集合里
				if(user!=null) {
					
					if(user.getGender().equals("1")) {
						mapMan.put(number, times);
						
						
					}else {
						mapWoman.put(number, times);
						
					}
				}
				}
				//进行升序排序
				  ArrayList<Entry<String,Long>> manList = new ArrayList<Map.Entry<String,
						  Long>>(mapMan.entrySet()); Collections.sort(manList, new
						  Comparator<Map.Entry<String, Long>>() { //降序排序
						  
						  @Override public int compare(Entry<String, Long> o1, Entry<String, Long> o2)
						  { return o1.getValue().compareTo(o2.getValue()); 
						 // return o2.getValue().compareTo(o1.getValue());
							  } });
						  ArrayList<Entry<String,Long>> womanList = new ArrayList<Map.Entry<String,
								  Long>>(mapWoman.entrySet()); Collections.sort(womanList, new
										  Comparator<Map.Entry<String, Long>>() { //降序排序
									  
									  @Override public int compare(Entry<String, Long> o1, Entry<String, Long> o2)
									  { return o1.getValue().compareTo(o2.getValue()); 
									  // return o2.getValue().compareTo(o1.getValue());
									  } });
								
								//分别获取男/女前十的人员信息
								
								for (int i = 0; i < manList.size(); i++) {
								
									User userMan = userMapper.findByNumber(manList.get(i).getKey());
									int rank = i+1;
									String getTime = manList.get(i).getValue()/3600+":"+(manList.get(i).getValue()%3600)/60+":"+manList.get(i).getValue()%60;
									userMan.setUserRank(rank)
									.setBottmDte(getTime);
									userMapper.updateRank(userMan);
									
								}
								//同上--女生
								for (int i = 0; i < womanList.size(); i++) {
									
									User userWoman = userMapper.findByNumber(womanList.get(i).getKey());
									int rank = i+1;
									String getTime = womanList.get(i).getValue()/3600+":"+(womanList.get(i).getValue()%3600)/60+":"+womanList.get(i).getValue()%60;
									userWoman.setUserRank(rank)
									.setBottmDte(getTime);
									userMapper.updateRank(userWoman);
										
								}
		
		
	}
	
}
