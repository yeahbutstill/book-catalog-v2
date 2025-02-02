package com.yeahbutstill.catalog.service.impl;

import com.yeahbutstill.catalog.config.ApplicationProperties;
import com.yeahbutstill.catalog.config.CloudProperties;
import com.yeahbutstill.catalog.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final ApplicationProperties appProperties;
    private final CloudProperties cloudProperties;
    Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);


    public GreetingServiceImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
        super();
        this.appProperties = appProperties;
        this.cloudProperties = cloudProperties;
    }


    @Override
    public String sayGreeting() {
        log.trace("this is log TRACE");
        log.debug("this is log DEBUG");
        log.info("this is log INFO");
        log.warn("this is log WARN");
        log.error("this is log ERROR");
        System.out.println(cloudProperties.getApiKey());
        TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
        return appProperties.getWelcomeText() + ", our timezone :" + timezone.getDisplayName() +
                ", our currency:" + appProperties.getCurrency();
    }


}
