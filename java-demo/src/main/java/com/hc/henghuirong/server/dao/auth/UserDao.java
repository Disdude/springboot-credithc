package com.hc.henghuirong.server.dao.auth;

import com.hc.henghuirong.server.common.model.auth.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author wenzhiwei
 */
public interface UserDao extends Mapper<User> {

    @Insert("INSERT into user (id,username,password,email,disabled,createTime,salt) VALUES (#{id},#{username},#{password},#{email},#{disabled},#{createTime},#{salt})")
    int add(User user);

    @Update("UPDATE user SET username=#{username},email=#{email},password=#{password} WHERE id=#{id}")
    void update(User user);

    @Update("")
    void updateRoles(String uid, List<String> rids);

    @Select("select * from user where id=#{id} limit 1")
    User get(@Param("id") String id);

    @Select("select count(username) from user where username=#{username}")
    boolean contains(@Param("name") String name);

    @Select("select * from user limit 100")
    List<User> list();

    @Select("select count(*) from user_role ur join role_resource rr on ur.role_id=rr.role_id where ur.uid=? and rr.resource_id=?")
    boolean hasResourcePermission(@Param("userId") String userId, @Param("resource_id") String resourceCode);

    int remove(String id);

    @Update("update user SET disabled=#{disabled} WHERE id=#{id}")
    int switchStatus(@Param("id") String id, @Param("disabled") boolean disabled);

    @Select("select * from user where username=#{username}")
    User findByUserName(@Param("username") String username);

    //判断用户名称是否重复
    @Select("select * from user where username =#{username}")
    List<User> getUserByUname(@Param("username") String username);

    //判断email是否重复
    @Select("select * from user  where email =#{email}")
    List<User> getUserByEmail(String email);

}
