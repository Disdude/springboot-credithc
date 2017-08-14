package com.hc.henghuirong.server.dao.auth;


import com.hc.henghuirong.server.common.model.auth.Menu;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author wenzhiwei
 */
public interface MenuDao extends Mapper<Menu> {

    @Insert("insert into menu (id,label,path,`level`,`order`,`url`,`type`,`style`,`disabled`) values (#{id},#{label},#{path},#{level},#{order},#{url},#{type},#{style},#{disabled})")
    int add(Menu menu);

    //todo diable
    @Update("update menu SET label=#{label},`order`=#{order},url=#{url},disabled=#{disabled},`type`=#{type},`style`=#{style} WHERE id=#{id}")
    void update(Menu menu);

    @Select("select * from menu where id=#{id}")
    Menu get(@Param("id") String code);

    //todo boolean
    @Select("select count(id) from menu where id=#{id}")
    boolean contains(String code);

    @Select("select * from menu limit 200")
    List<Menu> list();

    @Delete("DELETE FROM menu WHERE id=#{id}")
    int remove(@Param("id") String code);

    //todo disabled
    @Update("update menu SET disabled=#{disabled} WHERE id=#{id}")
    int switchStatus(@Param("id") String code, @Param("disabled") boolean disabled);

    @Select("select m.* from menu m join role_menu rm on m.id=rm.menu_id where rm.role_id=#{roleId}")
    List<Menu> roleMenus(@Param("roleId") String roleId);

    @Select("select m.* from menu m join role_menu rm on m.id=rm.menu_id join user_role ur on rm.role_id=ur.role_id where m.disabled=0 and ur.uid=#{userId}")
    List<Menu> getNavMenus(@Param("userId") String userId);
}
