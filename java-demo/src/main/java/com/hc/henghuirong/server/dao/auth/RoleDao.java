package com.hc.henghuirong.server.dao.auth;


import com.hc.henghuirong.server.common.model.auth.Role;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wenzhiwei
 */
public interface RoleDao extends Mapper<Role> {

    @Insert("INSERT into role (id,`name`,disabled,description) values (#{id},#{name},#{disabled},#{description})")
    int add(Role role);

    @Update("update role SET `name` =#{name},disabled=#{disabled},description=#{description} WHERE id=#{id}")
    int update(Role role);

    @Update("")
    int updateMenus(String rid, List<String> mids);

    void updateResources(String rid, List<String> resources);

    @Select("select count(`name`) from role where `name`=#{name}")
    boolean contains(@Param("name") String roleName);

    @Select("select * from role where id=#{id}")
    Role get(@Param("id") String id);

    @Select("select * from role limit 100")
    List<Role> list();

    @Delete("DELETE FROM role_menu WHERE role_id=#{id}")
    int remove(@Param("id") String id);

    @Delete("DELETE FROM role_menu WHERE menu_id=#{id}")
    int removeRoleMenuByMenuId(@Param("id") String menuId);

    @Delete("DELETE FROM role_resource WHERE resource_id=#{resourceId}")
    int removeRoleResourceByResourceId(@Param("resourceId") String resourceId);

    @Update("update role SET disabled=#{disabled} WHERE id=#{id}")
    int switchStatus(@Param("id") String id, @Param("disabled") boolean disabled);

    @Select("select * from role r join user_role ur on r.id=ur.role_id where ur.uid=#{userId}")
    List<Role> getRoles(@Param("userId") String userId);


}
