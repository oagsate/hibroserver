package com.oagsate.hibroserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oagsate.hibroserver.domain.Journal;
import com.oagsate.hibroserver.domain.Thought;

import java.util.List;
import java.util.Map;

public interface JournalService extends IService<Journal> {
    List<Map> getByUid(int uid);

    List<Map> getAll();
}
