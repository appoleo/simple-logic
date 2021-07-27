package com.ami.study.controller;

import com.ami.study.observable.EventContainer;
import com.ami.study.observable.TestEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangchendong
 * @date 2021/07/26
 */
@RestController
@RequestMapping("/observable")
public class ObservableController {

    @Resource
    private EventContainer<TestEvent> eventContainer;

    @PostMapping("/listen")
    public void listen() {
        TestEvent test = new TestEvent("test");
        eventContainer.publish(test);
    }
}
