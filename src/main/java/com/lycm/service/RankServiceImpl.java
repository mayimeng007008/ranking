package com.lycm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lycm.dao.RankMapper;
import com.lycm.pojo.Ranks;



@Service
public class RankServiceImpl implements RankService {
		@Autowired
		RankMapper rankMapper;
	@Override
	public List<Ranks> getAll() {
		Ranks rank = new Ranks();
		QueryWrapper<Ranks> qw = new QueryWrapper<>(rank);
		return rankMapper.selectList(qw);
	}
	
	
	
}









