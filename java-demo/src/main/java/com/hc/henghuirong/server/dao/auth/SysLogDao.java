package com.hc.henghuirong.server.dao.auth;

import com.hc.henghuirong.server.common.model.auth.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author wenzhiwei
 */
public interface SysLogDao extends Mapper<SysLog> {

    @Insert("INSERT into syslog (uid,content,operation,createTime,user) VALUES (#{uid},#{content},#{operation},#{createTime},#{user})")
    void add(SysLog sysLog);

    @Select("select * from syslog limit 300")
    List<SysLog> list();

    void clear();
}
