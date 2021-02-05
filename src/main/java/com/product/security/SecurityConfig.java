package com.product.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedMethods("POST");
  }

  private RequestMappingHandlerMapping requestMappingHandlerMapping;

  @Autowired
  public void setRequestHandlerMapping(RequestMappingHandlerMapping requestHandlerMapping) {
    this.requestMappingHandlerMapping = requestHandlerMapping;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors();
    http.httpBasic()
        .disable()
        .csrf()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
        .and()
        .exceptionHandling();
  }

  @Bean
  PasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
