package com.demo_service.demo_application;

/**
 * @author: mj
 * @date: 2020/4/24$
 * @desc: 事件发布   参数是数据传递
 */
public class EventData {
    private String content;
    private String Flag;

    public EventData() {
    }

    public EventData(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFlag() {
        return Flag == null ? "" : Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    @Override
    public String toString() {
        return "EventData{" +
                "content='" + content + '\'' +
                ", Flag='" + Flag + '\'' +
                '}';
    }
}


