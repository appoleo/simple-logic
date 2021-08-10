package com.ami.study.log;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangchendong
 * @date 2021/08/10
 */
@Slf4j
public class LogWrapper {

    public static void log(String format, LogStyle logColor, Object... args) {
        log.info(logColor.dye(format), args);
    }

    public static void log(String format, Object... args) {
        log.info(format, args);
    }
}
