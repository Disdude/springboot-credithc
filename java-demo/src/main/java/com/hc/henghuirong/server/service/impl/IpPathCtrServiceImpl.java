package com.hc.henghuirong.server.service.impl;

import com.hc.henghuirong.server.common.model.auth.IpPathControl;
import com.hc.henghuirong.server.dao.auth.IpPathCtrDao;
import com.hc.henghuirong.server.service.auth.IpPathCtrService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hucongcong on 2017/3/24.
 */
@Service
public class IpPathCtrServiceImpl implements IpPathCtrService {

    @Autowired
    IpPathCtrDao ipPathCtrDao;


    @Override
    public boolean pass(String ip, String path, Integer counts) {

        List<IpPathControl> allByIp = ipPathCtrDao.getAllByIp(ip);
        if (allByIp == null) {
            return false;
        }
        for (IpPathControl ipc : allByIp
                ) {
            if ("/**".equals(ipc.getPath()) || path.contains(ipc.getPath())) {
                if (ipc.isPathEnabled()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int create(IpPathControl ipPathControl) {
        //int insert = ipPathCtrDao.insert(ipPathControl);
        int i = ipPathCtrDao.add(ipPathControl);
        return i;
    }

    @Override
    public IpPathControl getIpPathControlById(Integer id) {
        return ipPathCtrDao.getIpPathControlById(id);
    }

    @Override
    public List<IpPathControl> getIpPathControlByIp(String ip) {
        return ipPathCtrDao.getAllByIp(ip);
    }

    @Override
    public List<IpPathControl> getAllIpPathControl() {
        return ipPathCtrDao.getAllList();
    }

    @Override
    public int modify(IpPathControl ipPathControl) {
        return ipPathCtrDao.update(ipPathControl);
    }

    @Override
    public int deleteById(Integer id) {
        return ipPathCtrDao.remove(id);
    }

    @Override
    public void switchPathStatus(Integer id, boolean pathEnabled) {
        ipPathCtrDao.switchPathStatus(id, pathEnabled);
    }

    @Override
    public void switchQpmStatus(Integer id, boolean qpmEnabled) {
        ipPathCtrDao.switchQpmStatus(id, qpmEnabled);
    }
}
