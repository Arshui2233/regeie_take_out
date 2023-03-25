package com.gjl.regeie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjl.regeie.entity.User;
import com.gjl.regeie.mapper.UserMapper;
import com.gjl.regeie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
}
