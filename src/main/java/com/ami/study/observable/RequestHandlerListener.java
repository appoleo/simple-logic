package com.ami.study.observable;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author wangchendong
 * @date 2021/07/27
 */
@Component // 注册监听器，此方式需事件在ApplicationContext创建完成后才可注册成功，否则采用spring.factories方式
public class RequestHandlerListener implements ApplicationListener<RequestHandledEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(RequestHandledEvent event) {
        System.out.println(event);
        Object source = event.getSource();
        if (source instanceof DispatcherServlet) {
            DispatcherServlet ds = (DispatcherServlet) source;

        }
    }
}
