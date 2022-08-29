package com.oagsate.hibroserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThoughtDao extends BaseMapper<Thought> {
}
