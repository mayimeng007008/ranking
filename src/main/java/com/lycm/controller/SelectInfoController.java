package com.lycm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lycm.pojo.Benedictions;
import com.lycm.pojo.User;
import com.lycm.service.RankingService;
import com.lycm.service.UserService;
import com.lycm.vo.SysResult;

@Controller
@CrossOrigin(origins = "*",allowCredentials = "true")
public class SelectInfoController {
	@Autowired
	UserService userService;
	
	
	
	String phones;
	
	
	@RequestMapping("/user")
	public String index() {
		return "user.html";
	}
	@RequestMapping("/showNumber")
	public String showNumber() {
		return "showNumber.html";
	}
	
	  @RequestMapping("/index")
	  public String ranking() {
		  return
	  "pengzhouIndex.html"; 
		  }
	  @RequestMapping("/benediction")
	  public String benediction() {
		  return "benediction.html";
		  
	  }
	  @RequestMapping("/getBenediction")
	  @ResponseBody
	  public SysResult getBenediction() {
		  System.out.println(".......ppp");
		 List<Benedictions> list= userService.findBenediction();
		 System.out.println(list);
		  return SysResult.success(list);
	  }
	 
	
	
	@RequestMapping("/findUserInfoByPhone/{phone}")
	@ResponseBody
	public SysResult findUserInfo(@PathVariable String phone) {
		User user = userService.findUserInfoByPhnoe(phone);
		phones=phone;
	
		return SysResult.success(user);
		
	}
	@RequestMapping("/getfindUserInfoByPhone")
	@ResponseBody
	public SysResult resfindUserInfo() {
		String phone = phones;
		User user = userService.findUserInfoByPhnoe(phone);
	
		return SysResult.success(user);
		
	}
	
}
