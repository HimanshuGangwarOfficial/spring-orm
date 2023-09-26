package com.orm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(value = PersistenceConfig.class)
@ComponentScan(basePackages = {"com.orm.service","com.orm.dao"})
@EnableTransactionManagement
public class RootConfig {

}
