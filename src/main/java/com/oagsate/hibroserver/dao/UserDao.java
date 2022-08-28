package com.oagsate.hibroserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oagsate.hibroserver.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
