package com.oagsate.hibroserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oagsate.hibroserver.dao.UserDao;
import com.oagsate.hibroserver.domain.User;
import com.oagsate.hibroserver.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
