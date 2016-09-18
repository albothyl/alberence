package com.java.alberence.configuration;

import com.java.alberence.application.security.MySavedRequestAwareAuthenticationSuccessHandler;
import com.java.alberence.application.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private MySavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.userDetailsService(userDetailsService)
			.passwordEncoder(new ShaPasswordEncoder(256)) //NOSONAR
			.and()
			.eraseCredentials(true);
	}

	protected void configure(HttpSecurity security) throws Exception {
		security
			.csrf().disable()
			.exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint)
				.and()
			.authorizeRequests()
				.antMatchers("/hello").permitAll()
				.antMatchers("/session/list").hasAuthority("VIEW_USER_SESSIONS").anyRequest().authenticated()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginProcessingUrl("/auth/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(authenticationSuccessHandler)
				.failureHandler(new SimpleUrlAuthenticationFailureHandler())
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logoutSuccess")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.and()
			.sessionManagement()
				.sessionFixation().changeSessionId()
				.maximumSessions(1).maxSessionsPreventsLogin(true)
				.sessionRegistry(new SessionRegistryImpl())
			;
	}

	@Bean
	public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
		return new MySavedRequestAwareAuthenticationSuccessHandler();
	}
	@Bean
	public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
		return new SimpleUrlAuthenticationFailureHandler();
	}
}
