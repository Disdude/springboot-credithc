package com.hc.henghuirong.server.dao.auth;

import com.hc.henghuirong.server.common.model.auth.IpPathControl;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by dell-3020 on 2017/3/24.
 */
public interface IpPathCtrDao extends Mapper<IpPathControl> {

    String FIELDS = "id,ip,path,path_enabled as pathEnabled,qpm,qpm_enabled as qpmEnabled,create_time as createTime,status";

    /**
     * 增添
     * @param IpPathControl
     * @return
     */
    @Insert("insert into ip_path_control(ip ,path,qpm,create_time) values(#{ip},#{path},#{qpm},now())")
    int add(IpPathControl IpPathControl);
//    @Insert("insert into ipPathControl(ip ,path,pathEnabled,qpm,qpmEnabled,createTime) values(#{ip},#{path},#{pathEnabled},#{qpm},#{qpmEnabled},#{createTime})")
//    int add(IpPathControl IpPathControl);

    /**
     * 修改
     * @return
     */
    @Update("update ip_path_control set ip=#{ip},path=#{path},qpm=#{qpm} where id=#{id}")
    int update(IpPathControl ipPathControl);

    /**
     * 通过Ip查询所有记录
     * @param ip
     * @return
     */
    @Select("select " + FIELDS + " from ip_path_control where status=1 and ip=#{ip}")
    List<IpPathControl> getAllByIp(@Param("ip")String ip);
    /**
     * 通过Id查询
     * @param id
     * @return
     */
    @Select("select " + FIELDS + " from ip_path_control where status=1 and id=#{id}")
    IpPathControl getIpPathControlById(@Param("id") Integer id);

    /**
     * 通过ip、path查询记录
     * @param ip
     * @return
     */
    @Select("select " + FIELDS + " from ip_path_control where status=1 and ip=#{ip} and path=#{path}")
    IpPathControl getByIpAndPath(@Param("ip") String ip,@Param("path") String path);

    /**
     * 查询所有记录数
     * @param code
     * @return
     */
    @Select("select count(id) from ip_path_control where status=1 and id=#{id}")
    int getCounts(@Param("id")Integer code);

    /**
     * 查询分页
     * @return
     */
    @Select("select " + FIELDS + " from ip_path_control where status=1 limit 200")
    List<IpPathControl> getAllList();

    /**
     * 删除
     * @param code
     * @return
     */
    @Update("update ip_path_control set status=0 WHERE id=#{id}")
    int remove(@Param("id") Integer code);

    /**
     *修改IP访问资源权限
     *  @param id
     * @param pathEnabled
     */
    @Update("update ip_path_control set path_enabled=#{pathEnabled} WHERE id=#{id}")
    void switchPathStatus(@Param("id")Integer id, @Param("pathEnabled")boolean pathEnabled);


    /**
     * ip访问上限状态控制
     * @param id
     * @param qpmEnabled
     */
    @Update("update ip_path_control set qpm_enabled=#{qpmEnabled} WHERE id=#{id}")
    void switchQpmStatus(@Param("id")Integer id, @Param("qpmEnabled")boolean qpmEnabled);
}
