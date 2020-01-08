package com.security.config;

import com.security.util.VerifyCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    VerifyCodeFilter verifyCodeFilter;



    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/jq/**")
                .antMatchers("/web/reg.html")
                .antMatchers("/user/reg")
                .antMatchers("/web/login.html")
                .antMatchers("/user/login")
                .antMatchers("/user/vercode")
                .antMatchers("/head.jpg");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http

                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                //设置表单登录
                .formLogin()
                .loginPage("/web/login.html").loginProcessingUrl("/user/login")
                .permitAll()
                .disable().cors();
    }

}
