package com.ami.study.observable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * @author wangchendong
 * @date 2021/07/27
 */
@Component // 注册监听器，此方式需事件在ApplicationContext创建完成后才可注册成功，否则采用spring.factories方式
public class ApplicationContextListener implements ApplicationListener<ApplicationContextEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        System.out.println(event);
        ApplicationContext applicationContext = event.getApplicationContext();

    }
}
