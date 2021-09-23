package com.ami.study.controller;

import com.ami.study.observable.EventContainer;
import com.ami.study.observable.TestEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangchendong
 * @date 2021/07/26
 */
@Slf4j
@Api(tags = "参数测试")
@RestController
@RequestMapping("/param")
public class ParamController {

    @Resource
    private EventContainer<TestEvent> eventContainer;

    @ApiOperation("测试参数封装1")
    @PostMapping(value = "/add", headers = "token=1")
    public void listen1(Person person) {
        log.info("param1: {}", person);
        log.info("add event1 ...");
        eventContainer.publish(new TestEvent(person));
    }

    @ApiOperation("测试参数封装2")
    @PostMapping(value = "/add", headers = "token=2")
    public void listen2(Person person) {
        log.info("param2: {}", person);
        log.info("add event2 ...");
        eventContainer.publish(new TestEvent(person));
    }

    @ApiOperation("测试参数封装3")
    @PostMapping(value = "/add")
    public void listen3(Person person) {
        log.info("param3: {}", person);
        log.info("add event3 ...");
        eventContainer.publish(new TestEvent(person));
    }

    @Data
    public static class Person {

        private String name;

        private Integer age;

        public void setName(String name) {
            this.name = name;
            log.info("set execute... {}", name);
        }
    }
}
