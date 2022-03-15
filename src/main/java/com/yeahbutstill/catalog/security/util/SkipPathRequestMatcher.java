package com.yeahbutstill.catalog.security.util;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class SkipPathRequestMatcher implements RequestMatcher {

    private final OrRequestMatcher skipMatcher;

    private final OrRequestMatcher processingMatcher;

    public SkipPathRequestMatcher(List<String> pathToSkip, List<String> processingPath) {
        List<RequestMatcher> m = pathToSkip.stream().map(AntPathRequestMatcher::new)
                .collect(Collectors.toList());
        skipMatcher = new OrRequestMatcher(m);

        List<RequestMatcher> p = processingPath.stream().map(AntPathRequestMatcher::new)
                .collect(Collectors.toList());
        processingMatcher = new OrRequestMatcher(p);

    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if (skipMatcher.matches(request)) {
            return false;
        }
        return processingMatcher.matches(request);
    }

}
