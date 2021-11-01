package com.ami.study.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author wangchendong
 */
@Component
public class GCConfiguration implements InitializingBean {

    /**
     * -XX:+UseG1GC
     */
    @Override
    public void afterPropertiesSet() {
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        garbageCollectorMXBeans.forEach(i -> System.out.println(i.getName()));
    }
}
