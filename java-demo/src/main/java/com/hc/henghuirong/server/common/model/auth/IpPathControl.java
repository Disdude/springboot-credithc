package com.hc.henghuirong.server.common.model.auth;

import com.hc.henghuirong.server.common.model.BaseObject;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * IP资源控制
 * Created by dell-3020 on 2017/3/24.
 */
public class IpPathControl extends BaseObject {


    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 来访IP
     */
    private String ip;

    /**
     * 请求访问路径
     */
    private String path;

    /**
     * 是否可以访问路径
     */
    private boolean pathEnabled;

    /**
     * 允许每分钟最大访问次数
     */
    private Integer qpm;

    /**
     * 控制访问次数是否有效
     */
    private boolean qpmEnabled;

    /**
     * 记录是否有效
     */
    private boolean status;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime;


    public IpPathControl() {
    }

    public IpPathControl(String ip, String path, boolean pathEnabled, Integer qpm, boolean qpmEnabled, boolean status, Date createTime) {
        this.ip = ip;
        this.path = path;
        this.pathEnabled = pathEnabled;
        this.qpm = qpm;
        this.qpmEnabled = qpmEnabled;
        this.status = status;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isPathEnabled() {
        return pathEnabled;
    }

    public void setPathEnabled(boolean pathEnabled) {
        this.pathEnabled = pathEnabled;
    }

    public Integer getQpm() {
        return qpm;
    }

    public void setQpm(Integer qpm) {
        this.qpm = qpm;
    }

    public boolean isQpmEnabled() {
        return qpmEnabled;
    }

    public void setQpmEnabled(boolean qpmEnabled) {
        this.qpmEnabled = qpmEnabled;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "IpPathControl{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", path='" + path + '\'' +
                ", pathEnabled=" + pathEnabled +
                ", qpm=" + qpm +
                ", qpmEnabled=" + qpmEnabled +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
