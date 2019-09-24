package com.lycm.service;

import java.util.List;

import com.lycm.pojo.Benedictions;
import com.lycm.pojo.User;

public interface UserService {

	User findUserInfoByPhnoe(String phone);

	List<Benedictions> findBenediction();

	User findByOpenId(String openId);

	List<User> findRank();

}
