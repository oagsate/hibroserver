package com.oagsate.hibroserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oagsate.hibroserver.dao.ImageDao;
import com.oagsate.hibroserver.dao.ThoughtDao;
import com.oagsate.hibroserver.domain.Image;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.service.ImageService;
import com.oagsate.hibroserver.service.ThoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl extends ServiceImpl<ImageDao, Image> implements ImageService {
    @Autowired
    private ImageDao imageDao;

//    @Override
//    public List<Map> getByUid(int uid) {
//        return thoughtDao.getByUid(uid);
//    }
//
//    @Override
//    public List<Map> getAll() {
//        return thoughtDao.getAll();
//    }
}
