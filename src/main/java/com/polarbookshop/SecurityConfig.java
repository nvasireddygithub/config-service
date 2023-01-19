package com.polarbookshop;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf().disable()
				.authorizeRequests(request -> 
					request
					.antMatchers("/actuator/**").permitAll()
					.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.build();
	}
}
