package com.e.demo_eventbus;

public class AsyncEvent {
    public final String threadInfo;

    public AsyncEvent(String threadInfo) {
        this.threadInfo = threadInfo;
    }
}
