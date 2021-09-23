package com.ami.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import springfox.documentation.RequestHandler;
import springfox.documentation.spi.service.RequestHandlerCombiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static springfox.documentation.RequestHandler.sortedPaths;
import static springfox.documentation.builders.BuilderDefaults.nullToEmptyList;
import static springfox.documentation.spi.service.contexts.Orderings.byPatternsCondition;

/**
 * @author wangchendong
 * @date 2021/09/23
 */
@Slf4j
@Component
public class RequestHandlerCombinerImpl implements RequestHandlerCombiner {

    @Override
    public List<RequestHandler> combine(List<RequestHandler> source) {
        List<RequestHandler> combined = new ArrayList<RequestHandler>();
        Map<String, List<RequestHandler>> byPath = new HashMap<>();
        log.debug("Total number of request handlers {}", nullToEmptyList(source).size());
        for (RequestHandler each : nullToEmptyList(source)) {
            String pathKey = sortedPaths(each.getPatternsCondition());
            log.debug("Adding key: {}, {}", pathKey, each.toString());
            byPath.putIfAbsent(pathKey, new ArrayList<>());
            byPath.get(pathKey).add(each);
        }
        for (String key : byPath.keySet()) {
            combined.addAll(byPath.get(key));
        }
        log.debug("Combined number of request handlers {}", combined.size());
        return combined.stream()
                .sorted(byPatternsCondition())
                .collect(toList());
    }
}
