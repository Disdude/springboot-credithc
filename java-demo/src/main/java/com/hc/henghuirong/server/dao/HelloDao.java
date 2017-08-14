package com.hc.henghuirong.server.dao;

import com.hc.henghuirong.server.common.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by wenzhiwei on 17-3-14.
 */
public interface HelloDao extends Mapper<User> {

    @Select("select * from user where id=#{id} limit 1 ")
    public User getuser(@Param("id") String id);

}
