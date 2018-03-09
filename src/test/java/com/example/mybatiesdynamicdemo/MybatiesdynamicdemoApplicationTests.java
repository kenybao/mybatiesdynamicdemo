package com.example.mybatiesdynamicdemo;

import com.domain.User;
import com.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatiesdynamicdemoApplicationTests {
  	@Autowired
	UserMapper userMapper;
	@Test
	public void contextLoads() {
		userMapper.insert(new User());
	}

}
