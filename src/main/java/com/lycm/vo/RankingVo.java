package com.lycm.vo;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RankingVo {
	String status;
	String bottmDte;
	String bottmRank;
	List<RankMan> rankMan;
	List<RankWoman> rankWoman;
	
}
