package com.gyuri.reddit.reddit.config;


import hu.gerviba.authsch2springbootstarter.AuthschConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MainConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    @Autowired
    private AuthschConfig authschConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        authschConfig.registerFilters(http);

        // Additional configuration: ...
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        authschConfig.addArgumentResolvers(argumentResolvers);
    }
}
