package com.ciandt.feedfront.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class configs extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/")
                .permitAll();

        // disabling csrf tokens and x-frame-options to be able to run h2 console (localhost:8080/console)
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
