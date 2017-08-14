package com.hc.henghuirong.server.service.impl;

import com.hc.henghuirong.server.dao.IdDao;
import com.hc.henghuirong.server.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Wu.Kang on 2017/4/24.
 */
@Service
public class IdServiceImpl implements IdService{

    @Autowired
    IdDao idDao;

    @Autowired
    BlockingQueue<Long> idQueue;

    @Override
    public long getId() {
        long id = 0;
        try
        {
            id = idQueue.take();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return id;
    }

    @Override
    @Transactional
    public long generateNewIds(int batchCount) {
        if(idDao.updateMaxId(batchCount) > 0){
            return idDao.getMaxId().getMaxId();
        }
        return 0;
    }
}
