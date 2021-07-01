package com.example.librarysystem.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // @Override
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {

    //     // add our users for in memory authentication
    //     User.UserBuilder users = User.withDefaultPasswordEncoder();
    //     auth.inMemoryAuthentication()
    //             .withUser(users.username("theint").password("test123").roles("USER"))
    //             .withUser(users.username("ssa").password("test123").roles("ADMIN"));
    // }

    //@Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.authorizeRequests()
    //          .anyRequest().authenticated()
    //             .and()
    //             .formLogin()
    //             .loginPage("/login")
    //             .loginProcessingUrl("/index")
    //             .permitAll()
    //             .and()
    //             .logout().permitAll()
    //             .and()
    //             .exceptionHandling().accessDeniedPage("/access-denied");

    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().anyRequest().permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
