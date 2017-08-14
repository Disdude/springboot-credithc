package com.hc.henghuirong.server.service.auth;

import com.hc.henghuirong.server.common.model.auth.ThirdParty;

import java.util.List;

/**
 * Created by wenzhiwei on 17-3-30.
 */
public interface ThirdPartyService {

    int insertThirdParty(ThirdParty thirdParty);

    int updateStatus(long id,int status);

    int updateKey(long id,String secretKey);

    int updateKeyAndDesc(long id,String secretKey,String desc);

    int delete(long id);

    List<ThirdParty> getList();

    ThirdParty getById(long id);

    ThirdParty getByThirdId(String thirdId);
}
