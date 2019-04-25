package com.hlx.cloudevaluation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hlx.cloudevaluation.dao")
public class CloudEvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEvaluationApplication.class, args);
	}

}
