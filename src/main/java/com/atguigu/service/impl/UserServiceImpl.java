package com.atguigu.service.impl;

import com.atguigu.dao.TUserDao;
import com.atguigu.dao.UserDao;
import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TUserDao userDao;

//    @Transactional
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
