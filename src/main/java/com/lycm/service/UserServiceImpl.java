package com.lycm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lycm.dao.BenedictionMapper;
import com.lycm.dao.UserMapper;
import com.lycm.pojo.Benedictions;
import com.lycm.pojo.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	BenedictionMapper benedictionMapper;
	
	
	@Override
	public User findUserInfoByPhnoe(String phone) {
		
			
		
		return userMapper.findByPhone(phone);
	}




	@Override
	public List<Benedictions> findBenediction() {
		
		
		return benedictionMapper.selectAll();
	}




	@Override
	public User findByOpenId(String openId) {
		
		return userMapper.selectByOpenId(openId);
	}




	@Override
	public List findRank() {
		List list = new ArrayList<>();
		List<User> man= userMapper.findRankMan();
		List<User> woman = userMapper.findRankMan();
		list.add(man);
		list.add(woman);
		return list;
	}

	
	}


