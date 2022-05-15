package com.app.school.config.security;

import com.app.school.services.AppUserServices;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   private final AppUserServices userServices;

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
         .csrf().disable()
         .authorizeRequests()
            .antMatchers("/", "/registration").permitAll()
         .anyRequest()
         .authenticated()
         .and()
         .formLogin();
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth){
      auth.authenticationProvider(daoAuthenticationProvider());
   }

   @Bean
   public DaoAuthenticationProvider daoAuthenticationProvider() {
      DaoAuthenticationProvider provider =
         new DaoAuthenticationProvider();
      provider.setPasswordEncoder(encoder());
      provider.setUserDetailsService(userServices);
      return provider;
   }

   @Bean
   PasswordEncoder encoder() {
      return new BCryptPasswordEncoder(10);
   }
}
