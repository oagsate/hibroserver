package com.oagsate.hibroserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oagsate.hibroserver.dao.JournalDao;
import com.oagsate.hibroserver.dao.ThoughtDao;
import com.oagsate.hibroserver.domain.Journal;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.service.JournalService;
import com.oagsate.hibroserver.service.ThoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JournalServiceImpl extends ServiceImpl<JournalDao, Journal> implements JournalService {
    @Autowired
    private JournalDao journalDao;

    @Override
    public List<Map> getByUid(int uid) {
        return journalDao.getByUid(uid);
    }

    @Override
    public List<Map> getAll() {
        return journalDao.getAll();
    }
}
