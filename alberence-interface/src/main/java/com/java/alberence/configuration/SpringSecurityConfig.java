package com.java.alberence.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.userDetailsService(userDetailsService)
			.passwordEncoder(new ShaPasswordEncoder(256)) //NOSONAR
			.and()
			.eraseCredentials(true);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
//				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/hello").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.failureUrl("/loginFail")
				.defaultSuccessUrl("/loginSuccess")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logoutSuccess")
				.invalidateHttpSession(true)
				.and()
			.csrf().disable();
	}
}