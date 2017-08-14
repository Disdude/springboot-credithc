package com.hc.henghuirong.server.config;

import com.hc.henghuirong.server.service.IdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Wu.Kang on 2017/4/25.
 */

public class IdProducer implements Runnable{
    private BlockingQueue<Long> idQueue;

    private IdService idService;

    private int threshHold;

    private int queueSize;

    private static final Logger logger = LoggerFactory.getLogger(IdProducer.class);

    public void setIdQueue(BlockingQueue idQueue){
        this.idQueue = idQueue;
    }

    public void setIdService(IdService idService){
        this.idService = idService;
    }

    public void setThreshHold(int threshHold) {
        this.threshHold = threshHold;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                //如果队列元素消耗超过门限
                if(idQueue.size() < threshHold) {
                    long maxid = idService.generateNewIds(queueSize);
                    for (long i = maxid - queueSize + 1; i <= maxid; ++i) {
                        logger.info("producer产生数据：" + i);
                        idQueue.put(i);
                        logger.info("producer放入数据：" + i);
                    }
                }
                //Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
