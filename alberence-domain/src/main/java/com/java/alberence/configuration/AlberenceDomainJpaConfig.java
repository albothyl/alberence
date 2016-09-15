package com.java.alberence.configuration;

import com.java.alberence.AlberenceDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

import static org.springframework.orm.jpa.vendor.Database.MYSQL;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = { AlberenceDomain.class })
public class AlberenceDomainJpaConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl(environment.getProperty("base.mysql.jdbc.url"));
		dataSource.setUsername(environment.getProperty("base.mysql.jdbc.username"));
		dataSource.setPassword(environment.getProperty("base.mysql.jdbc.password"));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(MYSQL);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getClass().getPackage().getName());
		factory.setDataSource(dataSource());
		factory.setJpaProperties(hibernateProperties(environment));
		factory.setPackagesToScan("com.java.alberence.domain");
		return factory;
	}

	private Properties hibernateProperties(Environment environment) {
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect",
			environment.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql",
			environment.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql",
			environment.getRequiredProperty("hibernate.format_sql"));
		jpaProperties.put("hibernate.hbm2ddl.auto",
			environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.ejb.naming_strategy",
			environment.getRequiredProperty("hibernate.ejb.naming_strategy"));

		jpaProperties.put("jadira.usertype.autoRegisterUserTypes",
			environment.getRequiredProperty("jadira.usertype.autoRegisterUserTypes"));
		jpaProperties.put("jadira.usertype.databaseZone",
			environment.getRequiredProperty("jadira.usertype.databaseZone"));

		return jpaProperties;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}
}
