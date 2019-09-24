package com.lycm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lycm.pojo.Benedictions;

@Mapper
public interface BenedictionMapper extends BaseMapper<Benedictions>{

	List<Benedictions> selectAll();
	
}
