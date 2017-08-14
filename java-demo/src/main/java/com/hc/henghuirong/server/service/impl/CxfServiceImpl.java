package com.hc.henghuirong.server.service.impl;

import com.hc.henghuirong.server.common.model.req.SignReq;
import com.hc.henghuirong.server.common.model.res.SignRes;
import com.hc.henghuirong.server.exceptions.BizException;
import com.hc.henghuirong.server.service.CxfService;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenzhiwei on 17-3-21.
 */
@WebService(targetNamespace = "http://service.server.henghuirong.hc.com/", endpointInterface = "com.hc.henghuirong.server.service.CxfService")
public class CxfServiceImpl implements CxfService {

    @Override
    public SignRes getSign(SignReq req) throws BizException {
        SignRes signRes;
        signRes = new SignRes();
        signRes.setSign(new String("hello"));
        Map map = new HashMap<>();
        map.put("name", "caifu");
        map.put("value", "hello");
        signRes.setData(map);
        return signRes;
    }

    @Override
    public SignRes getInfo(int id) throws BizException {
        SignRes signRes = new SignRes();
        signRes.setSign(String.valueOf(id));
        Map map = new HashMap<>();
        map.put("name", "caifu");
        map.put("value", "fsdafas");
        signRes.setData(map);
        return signRes;
    }
}
