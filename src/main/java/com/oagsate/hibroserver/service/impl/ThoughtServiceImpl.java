package com.oagsate.hibroserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oagsate.hibroserver.dao.ThoughtDao;
import com.oagsate.hibroserver.dao.UserDao;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;
import com.oagsate.hibroserver.service.ThoughtService;
import com.oagsate.hibroserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThoughtServiceImpl extends ServiceImpl<ThoughtDao, Thought> implements ThoughtService {
    @Autowired
    private ThoughtDao thoughtDao;

    @Override
    public List<Thought> getByUid(int uid) {
        return thoughtDao.getByUid(uid);
    }
}
