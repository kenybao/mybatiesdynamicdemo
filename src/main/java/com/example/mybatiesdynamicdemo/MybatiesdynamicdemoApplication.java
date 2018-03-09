package com.example.mybatiesdynamicdemo;

import com.domain.User;
import com.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
@MapperScan(basePackages  = "com.mapper")
public class MybatiesdynamicdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatiesdynamicdemoApplication.class, args);
	}
}
