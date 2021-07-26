package com.ami.study.observable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wangchendong
 * @date 2021/07/26
 */
@Slf4j
@Component
public class Test2Listener implements AppListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent event) {
        log.info("listen event of {} {}", event, event.getTimestamp());
    }
}
