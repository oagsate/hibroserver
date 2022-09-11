package com.oagsate.hibroserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oagsate.hibroserver.domain.Journal;
import com.oagsate.hibroserver.domain.Thought;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface JournalDao extends BaseMapper<Journal> {
    @Select("select journal.id,journal.content,journal.uid,journal.create_time as createTime,journal.update_time as updateTime,user.name,user.avatar from journal inner join user on journal.uid = user.id where journal.uid = #{uid}")
    List<Map> getByUid(int uid);

    @Select("select journal.id,journal.content,journal.uid,journal.create_time as createTime,journal.update_time as updateTime,user.name,user.avatar from journal inner join user on journal.uid = user.id")
    List<Map> getAll();
}
