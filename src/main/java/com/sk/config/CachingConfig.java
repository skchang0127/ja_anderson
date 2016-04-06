package com.sk.config;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {

    private static final Logger logger = Logger.getLogger(CachingConfig.class);


}
