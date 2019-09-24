package com.lycm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lycm.pojo.User;
import com.lycm.service.RankingService;
import com.lycm.service.UserService;



@Controller
@CrossOrigin(origins = "*",allowCredentials = "true")
public class RankingController {
	@Autowired
	RankingService rankingService;
	@Autowired
	UserService userService;
	//微信根据openid查询自己排名
	@RequestMapping(value="/getRankWX/{openId}",method=RequestMethod.GET)
	@ResponseBody
	public User getRanWX(@PathVariable String openId)  {
		rankingService.getRanking();
		return userService.findByOpenId(openId);
	}
	
	
	
	//查询总排名
	@RequestMapping(value="/getRankWeb",method=RequestMethod.GET)
	@ResponseBody
	public List getRanWeb()  {
		rankingService.getRanking();
		List list = userService.findRank();
		System.out.println(list);
		return list;
	}
	
}
