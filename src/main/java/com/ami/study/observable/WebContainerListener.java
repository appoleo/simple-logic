package com.ami.study.observable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wangchendong
 * @date 2021/09/23
 */
@Slf4j
public class WebContainerListener implements ApplicationListener<WebServerInitializedEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        try {
            log.info("swagger 文档地址：http://" + InetAddress.getLocalHost().getHostAddress()
                    + ":" + event.getWebServer().getPort() + "/logic/doc.html");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
