package com.hc.henghuirong.server.service.auth;


import com.hc.henghuirong.server.common.model.auth.SysLog;
import com.hc.henghuirong.server.dao.auth.SysLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author wenzhiwei
 */
@Service
public class SysLogService {

    @Autowired
    protected SysLogDao sysLogDao;

    public void create(SysLog sysLog) {
        sysLogDao.add(sysLog);
    }


    public void clear() {
        sysLogDao.clear();
    }


    public List<SysLog> list() {
        return sysLogDao.list();
    }
}
