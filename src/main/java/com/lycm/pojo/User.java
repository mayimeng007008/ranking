package com.lycm.pojo;

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
public class User {
	@TableId(type = IdType.AUTO)
	private Integer userId;
	private String name;
	private String phone;
	private String openId;
	private String gender;
	private String number;
	private int userRank;
	private String bottmDte;
	private String pzNumber;
	
}
