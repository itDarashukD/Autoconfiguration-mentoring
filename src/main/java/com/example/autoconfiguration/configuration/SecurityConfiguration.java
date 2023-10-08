package com.example.autoconfiguration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
	       .authorizeHttpRequests(authReq -> authReq
                .antMatchers("/actuator/**").permitAll()
	       .antMatchers(HttpMethod.GET,"/user/**").permitAll()
	       .antMatchers(HttpMethod.POST,"/user/*").permitAll()
	       .antMatchers(HttpMethod.PUT,"/user/*").permitAll()
	       .antMatchers(HttpMethod.DELETE,"/user/**").permitAll()
		      .anyRequest()
		      .authenticated())

                .httpBasic();

        return http.build();
    }

}
