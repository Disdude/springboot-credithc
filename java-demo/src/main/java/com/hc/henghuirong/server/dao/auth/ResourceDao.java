package com.hc.henghuirong.server.dao.auth;


import com.hc.henghuirong.server.common.model.auth.Resource;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author wenzhiwei
 */
public interface ResourceDao extends Mapper<Resource> {

    @Insert("INSERT INTO resource (id, title, disabled, url, description) values (#{id},#{title},#{disabled},#{url},#{description})")
    int add(Resource resource);

    @Update("UPDATE resource SET title=#{title},disabled=#{resource},url=#{url},description=#{description} WHERE `id`=#{id}")
    int update(Resource resource);

    @Select("select * from resource where id=#{resourceId}")
    Resource get(@Param("resourceId") String code);

    @Select("select * from resource limit 300")
    List<Resource> list();

    @Delete("DELETE FROM resource WHERE id=#{resourceId}")
    int remove(@Param("resourceId") String code);

    @Update("update resource SET disabled=#{disabled} WHERE id=#{code}")
    int switchStatus(@Param("code") String code, @Param("disabled") boolean disabled);

    @Select("select re.* from  role_resource rr  join resource re on re.id=rr.resource_id where rr.role_id=#{roleId}")
    List<Resource> listByRole(@Param("roleId") String roleId);

    @Select("select * from resource WHERE disabled=0 limit 300")
    List<Resource> getEnableResources();


}
