package com.hc.henghuirong.server.lts;

import com.github.ltsopensource.core.commons.utils.CollectionUtils;
import com.github.ltsopensource.core.domain.JobResult;
import com.github.ltsopensource.jobclient.support.JobCompletedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 任务执行结果反馈回调接口
 * Created by wenzhiwei on 17-4-11.
 */
//@JobCompletedHandler4JobClient
public class JobCompletedHandlerImpl implements JobCompletedHandler {

    private static Logger logger = LoggerFactory.getLogger(JobCompletedHandlerImpl.class);

    @Override
    public void onComplete(List<JobResult> jobResults) {
        // 任务执行反馈结果处理
        if (CollectionUtils.isNotEmpty(jobResults)) {
            for (JobResult jobResult : jobResults) {
                logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 任务执行完成：" + jobResult);
            }
        }
    }
}
