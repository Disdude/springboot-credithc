package com.hc.henghuirong.server.service.auth;

import com.hc.henghuirong.server.common.model.auth.IpPathControl;

import java.util.List;

/**
 * Created by hucongcong on 2017/3/24.
 */
public interface IpPathCtrService {

    /**
     * 验证IP是否通过
     * @param ip
     * @param path
     * @return
     */
        boolean pass(String ip,String path,Integer counts);

    /**
     * 创建IP资源关联
     *  @param ipPathControl
     * @return
     */
        int create(IpPathControl ipPathControl);

    /**
     * 根据Id获取对象
     * @param id
     * @return
     */
        IpPathControl getIpPathControlById(Integer id);
    /**
     * 根据Ip获取对象集合
     * @param ip
     * @return
     */
        List<IpPathControl> getIpPathControlByIp(String ip);


    /**
     * 获取所有信息
     * @return
     */
        List<IpPathControl> getAllIpPathControl();

    /**
     *  修改
     *  @param ipPathControl
     * @return
     */
        int modify(IpPathControl ipPathControl);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
        int deleteById(Integer id);

    /**
     * 修改ip访问权限 true：允许访问
     * @param id
     * @param pathEnabled
     */
    void switchPathStatus(Integer id, boolean pathEnabled);
    /**
     * ip访问上限控制 true：控制生效
     * @param id
     * @param qpmEnabled
     */
    void switchQpmStatus(Integer id, boolean qpmEnabled);
}
