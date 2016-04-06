package com.sk.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.mvc.Controller;

@Configuration
@ComponentScan(basePackages = "com.sk.**.*", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Import({CachingConfig.class,DaoConfig.class})
public class AppConfig {
}
