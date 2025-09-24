package com.design.employeesManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.design.employeesManagement.mapper")
@ComponentScan(value="com.design")
@EnableScheduling //定时任务注解
public class EmployeesManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesManagementApplication.class, args);
	}

}
