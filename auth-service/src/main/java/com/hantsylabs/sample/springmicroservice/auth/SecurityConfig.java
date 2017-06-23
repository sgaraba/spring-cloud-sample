package com.hantsylabs.sample.springmicroservice.auth;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.inject.Inject;

/**
 * Created by hantsy on 6/17/2017.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Inject
    private AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .formLogin().loginPage("/login").permitAll()
            .and()
                .requestMatchers().antMatchers("/login", "/signup", "/oauth/authorize", "/oauth/confirm_access")
            .and()
                .authorizeRequests().anyRequest().authenticated();
        // @formatter:on
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.parentAuthenticationManager(authenticationManager);
//    }
}
