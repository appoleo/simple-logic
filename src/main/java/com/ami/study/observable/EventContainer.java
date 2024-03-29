package com.ami.study.observable;

import com.ami.study.log.LogStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wangchendong
 * @date 2021/07/26
 */
@Slf4j
@Component
public class EventContainer<E extends AppEvent> implements InitializingBean {

    @Resource
    private Map<String, AppListener<E>> listenerMap;

    private int count;

    private final Map<Class<E>, List<AppListener<E>>> eventListeners = new LinkedHashMap<>(16);

    /**
     * 注册监听
     *
     * @throws Exception throw exception while some wrong on registering
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("register listeners begin");
        for (AppListener<E> listener : listenerMap.values()) {
            Type genericInterface = listener.getClass().getGenericInterfaces()[0];
            if (genericInterface instanceof ParameterizedType) {
                Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
                // noinspection unchecked
                Class<E> parameterType = (Class<E>) Class.forName(actualTypeArgument.getTypeName());
                if (eventListeners.containsKey(parameterType)) {
                    eventListeners.get(parameterType).add(listener);
                } else {
                    LinkedList<AppListener<E>> appListeners = new LinkedList<>();
                    appListeners.add(listener);
                    eventListeners.put(parameterType, appListeners);
                }
                count++;
            }
        }
        log.info(LogStyle.BLACK.dye("register listeners end, {} listeners have registered"), count);
        log.info(LogStyle.RED.dye("register listeners end, {} listeners have registered"), count);
        log.info(LogStyle.GREEN.dye("register listeners end, {} listeners have registered"), count);
        log.info(LogStyle.YELLOW.dye("register listeners end, {} listeners have registered"), count);
        log.info(LogStyle.BLUE.dye("register listeners end, {} listeners have registered"), count);
        log.info(LogStyle.PURPLE.dye("register listeners end, {} listeners have registered"), count);
        log.info(LogStyle.SKY.dye("register listeners end, {} listeners have registered"), count);
        log.info(LogStyle.WHITE.dye("register listeners end, {} listeners have registered"), count);
    }

    public void publish(E event) {
        if (eventListeners.containsKey(event.getClass())) {
            List<AppListener<E>> appListeners = eventListeners.get(event.getClass());
            appListeners.forEach(listener -> listener.onApplicationEvent(event));
        }
    }
}
