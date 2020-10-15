package com.example.reactspringdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private SpringDataJpaUserDetailsService userDetailsService;

  @Override
  public void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception{
    authManagerBuilder
        .userDetailsService(this.userDetailsService)
        .passwordEncoder(Manager.PASSWORD_ENCODER);

  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
          .antMatchers("/built/**").permitAll()
          .anyRequest().authenticated()
          .and()
        .formLogin()
          .defaultSuccessUrl("/", true)
          .permitAll()
          .and()
        .httpBasic()
          .and()
        .csrf().disable()
        .logout()
          .logoutSuccessUrl("/");
  }

}
