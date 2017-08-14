package com.hc.henghuirong.server.lts;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.spring.tasktracker.JobRunnerItem;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.logger.BizLogger;
import com.github.ltsopensource.tasktracker.runner.LtsLoggerFactory;
import com.hc.henghuirong.server.config.RabbitProperties;
import com.hc.henghuirong.server.service.SendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wenzhiwei on 17-4-12.
 * 任务调度
 */
//@LTS
public class JobScheduler {


    private static Logger logger = LoggerFactory.getLogger(JobScheduler.class);

    @Autowired
    SendMessageService sendMessageService;

    @Autowired
    RabbitProperties rabbitProperties;

    @JobRunnerItem(shardValue = "111")
    public Result runJob1(Job job) throws Throwable {
        try {
            Thread.sleep(1000L);

            logger.info("runJob shard value 111 我要执行：" + job);
            BizLogger bizLogger = LtsLoggerFactory.getBizLogger();
            // 会发送到 LTS (JobTracker上)
            bizLogger.info("111测试，业务日志啊啊啊啊啊");

        } catch (Exception e) {
            logger.info("Run job failed!", e);
            return new Result(Action.EXECUTE_LATER, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
    }

    @JobRunnerItem(shardValue = "222")
    public void runJob2() throws Throwable {
        try {
            logger.info("runJob shard value 222 我要执行");
            BizLogger bizLogger = LtsLoggerFactory.getBizLogger();
            // 会发送到 LTS (JobTracker上)
            bizLogger.info("222测试，业务日志啊啊啊啊啊");
        } catch (Exception e) {
            logger.info("Run job failed!", e);
        }
    }


    @JobRunnerItem(shardValue = "rabbitsend")
    public Result runJobSend(Job job) throws Throwable {
        try {
            logger.info("runJob send rabbit message 我要执行");
            BizLogger bizLogger = LtsLoggerFactory.getBizLogger();
            sendMessageService.sendMessage(rabbitProperties.getExchange(), rabbitProperties.getRoutineKey(), job.getParam("content"));
            // 会发送到 LTS (JobTracker上)
            bizLogger.info("rabbit测试成功了");
        } catch (Exception e) {
            logger.info("Run rabbit job failed!", e);
            return new Result(Action.EXECUTE_LATER, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
    }

    @JobRunnerItem(shardValue = "t_555")
    public Result runJob5(Job job) throws Throwable {
        try {
            Thread.sleep(1000L);

            logger.info("runJob shard value 555 我要执行：" + job);
            BizLogger bizLogger = LtsLoggerFactory.getBizLogger();
            // 会发送到 LTS (JobTracker上)
            bizLogger.info("555测试，业务日志啊啊啊啊啊");

        } catch (Exception e) {
            logger.info("Run job failed!", e);
            return new Result(Action.EXECUTE_LATER, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
    }

}
