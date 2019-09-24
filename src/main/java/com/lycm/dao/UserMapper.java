package com.lycm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lycm.pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{

	User findByNumber(String number);

	void updateRank(User userMan);

	User findByPhone(String phone);

	User selectByOpenId(String openId);

	List<User> findRankMan();

	
		
	
}
