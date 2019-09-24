package com.lycm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lycm.dao.InfoMapper;
import com.lycm.dao.UserMapper;
import com.lycm.pojo.Info;
import com.lycm.util.RankUtil;

@Service
public class RankingServiceImpl implements RankingService {
	
	@Autowired
	InfoMapper infoMapper;
	@Autowired
	UserMapper userMapper;

	@Override
	public void getRanking() {
		List<Info> list = infoMapper.findAll();
		if(list!=null) {
			RankUtil util = new RankUtil();
			util.rankByTcp();
		}else {
			
			
			
		}
				
		
	}


	
}









