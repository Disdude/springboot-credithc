package com.hc.henghuirong.server.disraptor;

import com.github.ltsopensource.core.json.JSON;
import com.lmax.disruptor.EventHandler;

/**
 * Created by wenzhiwei on 17-4-14.
 */
public class LogEventHandler implements EventHandler<LogEvent> {
    @Override
    public void onEvent(LogEvent logEvent, long l, boolean b) throws Exception {
        System.out.println(JSON.toJSONString(logEvent));
    }
}
