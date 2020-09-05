package com.atguigu.test;

import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    UserService userService;
    @Test
    public void testTUser(){
        List<User> all = userService.findAll();
        all.forEach(System.out::println);
    }

    @Autowired
    DataSource dataSource;
    @Test
    public void testDruid(){
        System.out.println("dataSource = " + dataSource.getClass());
    }
}
