package com.hc.henghuirong.server.disraptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by wenzhiwei on 17-4-14.
 */
public class LogEventFactory implements EventFactory<LogEvent> {
    @Override
    public LogEvent newInstance() {
        return new LogEvent();
    }
}
