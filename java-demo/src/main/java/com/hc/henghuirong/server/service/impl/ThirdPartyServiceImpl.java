package com.hc.henghuirong.server.service.impl;

import com.hc.henghuirong.server.common.enums.ThirdPartyStatus;
import com.hc.henghuirong.server.common.model.auth.ThirdParty;
import com.hc.henghuirong.server.dao.auth.ThirdPartyDao;
import com.hc.henghuirong.server.service.auth.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/3/30.
 */
@Service
public class ThirdPartyServiceImpl implements ThirdPartyService {
    @Autowired
    ThirdPartyDao thirdPartyDao;

    public int insertThirdParty(ThirdParty thirdParty) {
        validate(thirdParty);
        ThirdParty thirdParty1 = thirdPartyDao.getByThirdId(thirdParty.getThirdId().trim());
        if(thirdParty1 != null)
        {
            return -1; //数据重复
        }
        //新增的第三方默认状态为启用
        thirdParty.setStatus(ThirdPartyStatus.AVAILABLE.getStatus());
        return thirdPartyDao.add(thirdParty);
    }

    @Override
    public int updateStatus(long id, int status) {
        if(ThirdPartyStatus.of(status) == null)
        {
            return -1; //状态不正确
        }
        return thirdPartyDao.updateStatus(id, status);
    }

    @Override
    public int updateKey(long id, String secretKey) {
        return thirdPartyDao.updateKey(id, secretKey);
    }

    @Override
    public int updateKeyAndDesc(long id, String secretKey, String desc) {
        return thirdPartyDao.updateKeyAndDesc(id, secretKey, desc);
    }

    @Override
    public int delete(long id) {
        return thirdPartyDao.updateStatus(id, ThirdPartyStatus.DELETED.getStatus());
    }

    @Override
    public List<ThirdParty> getList() {
        return thirdPartyDao.getAll();
    }

    @Override
    public ThirdParty getById(long id) {
        return thirdPartyDao.getById(id);
    }

    @Override
    public ThirdParty getByThirdId(String thirdId) {
        return thirdPartyDao.getByThirdId(thirdId);
    }

    private void validate(ThirdParty thirdParty) {
        Assert.hasText(thirdParty.getThirdId());
        Assert.hasText(thirdParty.getDesc());
        Assert.hasText(thirdParty.getSecretKey());
    }
}
