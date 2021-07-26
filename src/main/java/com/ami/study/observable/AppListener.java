package com.ami.study.observable;

/**
 * @author wangchendong
 * @date 2021/07/26
 */
@FunctionalInterface
public interface AppListener<E extends AppEvent> {

    void onApplicationEvent(E event);
}
