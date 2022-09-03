package com.oagsate.hibroserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ThoughtDao extends BaseMapper<Thought> {
    @Select("select thought.id,thought.content,thought.uid,thought.create_time as createTime,user.name from thought inner join user on thought.uid = user.id where thought.uid = #{uid}")
    List<Map> getByUid(int uid);

    @Select("select thought.id,thought.content,thought.uid,thought.create_time as createTime,user.name from thought inner join user on thought.uid = user.id")
    List<Map> getAll();
}
