package com.lycm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.lycm")
//@MapperScan("com.lycm.dao")
public class PengzhouApplication {

	public static void main(String[] args) {
		SpringApplication.run(PengzhouApplication.class, args);
	}

}
