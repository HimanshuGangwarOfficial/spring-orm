package com.orm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.orm.entities.Address;

@Configuration
@PropertySource("classpath:db.properties")
public class PersistenceConfig {

	@Bean
	public DataSource dataSource(@Value("${db.driverClassName}") String driverClassName, @Value("${db.url}") String url,
			@Value("${db.username}") String username, @Value("${db.password}") String password) {

		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClassName);

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.show_sql", true);
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.setAnnotatedClasses(new Class<?>[] { Address.class });

		return sessionFactory;
	}

	@Bean
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {

		return new HibernateTemplate(sessionFactory);
	}

	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {

		return new HibernateTransactionManager(sessionFactory);

	}

}
