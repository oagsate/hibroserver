package com.oagsate.hibroserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;

import java.util.List;

public interface ThoughtService extends IService<Thought> {
    List<Thought> getByUid(int uid);
}
