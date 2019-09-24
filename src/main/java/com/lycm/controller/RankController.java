package com.lycm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lycm.pojo.Ranks;
import com.lycm.service.RankService;

@Controller
@CrossOrigin(origins = "*",allowCredentials = "true")
public class RankController {
	@Autowired
	RankService rankService;
	
	
	
	@RequestMapping("/rank")
	@ResponseBody
	public List<Ranks> getRank(){
		
		
		
		return rankService.getAll();
		
	}
}
