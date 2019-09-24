package com.lycm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lycm.pojo.Info;

@Mapper
public interface InfoMapper extends BaseMapper<Info>{
	List<Info> findAll();

	
	
		
	
}
