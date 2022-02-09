package org.deanframework.component.task;

/**
 * @auther Dean
 */
public interface AbstractTask {

    /**
     * 定时任务
     */
    void schedule();

    /**
     * 业务处理
     */
    void handle();
}
