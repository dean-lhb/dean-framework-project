package org.deanframework.component.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther Dean
 */
@Slf4j
public abstract class AbstractBaseTask implements AbstractTask {

    private boolean isRuning = false;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public synchronized void run() {
        if (isRuning) {
            log.info("\n ###定时任务未执行完###{}", this.getClass().getSimpleName());
            return;
        }
        log.debug("\n ###执行定时任务###{}###", this.getClass().getSimpleName());
        isRuning = true;
        try {
            executor.execute(() -> {
                try {
                    handle();
                } catch (Exception e){
                    log.error("\n ###定时任务业务异常###", e);
                } finally {
                    isRuning = false;
                }
            });
        } catch (Throwable t) {
            isRuning = false;
            log.error("\n ###定时任务异常###", t);
        }
    }
}
