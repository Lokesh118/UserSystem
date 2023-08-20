package com.googledrive.usersystem.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.googledrive.usersystem.service.UserService;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     // TODO Auto-generated method stub
    //     super.configure(auth);
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        // http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter);
        // super.configure(http);
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login");
    }
}
