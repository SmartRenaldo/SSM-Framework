package com.x.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Gavin
 */
// 标志该类是Spring的核心配置类
@Configuration
// <context:property-placeholder location="classpath:jdbc.properties"/>
@ComponentScan("com.x")
// <import resource="">
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {
}
