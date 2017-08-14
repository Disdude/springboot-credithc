package com.hc.henghuirong.server.dao;

import com.hc.henghuirong.server.common.model.UidSequence;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Wu.Kang on 2017/4/24.
 */
public interface IdDao extends Mapper<UidSequence>{
    @Update("update uid_sequence set max_id = max_id + #{batchCount}")
    int updateMaxId(@Param("batchCount") int batchCount);

    @Select("select id, max_id as maxId from uid_sequence limit 1")
    UidSequence getMaxId();
}
