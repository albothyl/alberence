package com.java.alberence.configuration;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.java.alberence.AlberenceInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { AlberenceInterface.class })
public class AlberenceWebServletApplicationContextConfig extends WebMvcConfigurationSupport {

	@Value("${handlebars.caching}")
	private boolean caching;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public HandlebarsViewResolver handlebarsViewResolver() {
		HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();
		viewResolver.setFailOnMissingFile(false);
		viewResolver.setCache(caching);

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".hbs");

		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
