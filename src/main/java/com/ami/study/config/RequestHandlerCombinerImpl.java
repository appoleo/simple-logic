package com.ami.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.BuilderDefaults;
import springfox.documentation.spi.service.RequestHandlerCombiner;
import springfox.documentation.spi.service.contexts.Orderings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangchendong
 * @date 2021/09/23
 */
@Slf4j
@Component
public class RequestHandlerCombinerImpl implements RequestHandlerCombiner {

    /**
     * 重写默认方法，提供的默认方法中会过滤掉path相同的接口，只会保留一个
     *
     * @param source api列表
     * @return 排序后的api列表
     * @see springfox.documentation.spring.web.plugins.DefaultRequestHandlerCombiner#combine(java.util.List)
     */
    @SuppressWarnings("JavadocReference")
    @Override
    public List<RequestHandler> combine(List<RequestHandler> source) {
        List<RequestHandler> combined = new ArrayList<>();
        Map<String, List<RequestHandler>> byPath = new HashMap<>();
        log.debug("Total number of request handlers {}", BuilderDefaults.nullToEmptyList(source).size());
        for (RequestHandler each : BuilderDefaults.nullToEmptyList(source)) {
            String pathKey = RequestHandler.sortedPaths(each.getPatternsCondition());
            log.debug("Adding key: {}, {}", pathKey, each);
            byPath.putIfAbsent(pathKey, new ArrayList<>());
            byPath.get(pathKey).add(each);
        }
        for (String key : byPath.keySet()) {
            combined.addAll(byPath.get(key));
        }
        log.debug("Combined number of request handlers {}", combined.size());
        return combined.stream()
                .sorted(Orderings.byPatternsCondition())
                .collect(Collectors.toList());
    }
}
