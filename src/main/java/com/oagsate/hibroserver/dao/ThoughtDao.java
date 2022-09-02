package com.oagsate.hibroserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ThoughtDao extends BaseMapper<Thought> {
    @Select("SELECT * FROM THOUGHT INNER JOIN USER ON THOUGHT.UID = USER.ID WHERE THOUGHT.UID = #{uid}")
    List<Thought> getByUid(int uid);
}
