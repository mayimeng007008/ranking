package com.lycm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RankWoman {
	String rank;
	String name;
	String number;
	String date;
	String pzNumber;
}
