package com.java.alberence.configuration;

import com.java.alberence.AlberenceDomain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({ AlberenceDomainJpaConfig.class })
@ComponentScan(basePackageClasses = { AlberenceDomain.class })
public class AlberenceDomainApplicationContextConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
