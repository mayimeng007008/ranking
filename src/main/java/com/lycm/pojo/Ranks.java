package com.lycm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Ranks {
	private String ranks;
	private String name;
	private String gender;
	private String pz_number;
	private String time;
}
