package com.hc.henghuirong.server.lts;

import com.github.ltsopensource.jobclient.JobClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * job 初始化
 * Created by wenzhiwei on 17-4-11.
 */
//@Component
public class JobClientReferenceBean implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(JobClientReferenceBean.class);

    /**
     * 自己的业务类,就可以这样引用了
     */
    @Autowired
    private JobClient jobClient;

    @Override
    public void afterPropertiesSet() throws Exception {

        // 这里模拟提交任务
//        Job job = new Job();
//        job.setTaskId("t_555");
//        job.setParam("shopId", "1122222221");
//        job.setTaskTrackerNodeGroup("test_trade_TaskTracker");
//        job.setNeedFeedback(true);
//        job.setReplaceOnExist(true);        // 当任务队列中存在这个任务的时候，是否替换更新
//        Response response = jobClient.submitJob(job);
//
//        logger.info("submit job success：", JSON.toJSONString(response));
//
//        job.setTaskId("t_111");
//        job.setParam("shopId", "11222222454");
//        job.setTaskTrackerNodeGroup("test_trade_TaskTracker");
//        job.setNeedFeedback(true);
//        job.setReplaceOnExist(true);
//        job.setCronExpression("35 * * * * ? *"); //每分钟的35秒执行一次
//        Response response1 = jobClient.submitJob(job);
//        logger.info("submit job success：", JSON.toJSONString(response1));

//        job.setTaskId("t_122");
//        job.setParam("shopId", "11222222454");
//        job.setTaskTrackerNodeGroup("test_trade_TaskTracker");
//        job.setNeedFeedback(true);
//        job.setReplaceOnExist(true);
//        job.setCronExpression("55 * * * * ? *"); //每分钟的35秒执行一次
//        Response response2 = jobClient.submitJob(job);

//        logger.info("submit job success：", JSON.toJSONString(response2));

    }
}
