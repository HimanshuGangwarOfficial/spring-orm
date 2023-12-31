package com.orm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath*:com/orm/common/application-context.xml")
@EnableTransactionManagement
public class RootConfig {

}
