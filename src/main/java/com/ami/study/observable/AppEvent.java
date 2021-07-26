package com.ami.study.observable;

import java.util.EventObject;

/**
 * @author wangchendong
 * @date 2021/07/26
 */
public abstract class AppEvent extends EventObject {

    private final long timestamp;

    public AppEvent(Object source) {
        super(source);
        timestamp = System.currentTimeMillis();
    }

    public final long getTimestamp() {
        return timestamp;
    }
}
