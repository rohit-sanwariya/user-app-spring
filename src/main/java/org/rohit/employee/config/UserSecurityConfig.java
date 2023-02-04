package org.rohit.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class UserSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user);

    }

    @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception{

      return   http.csrf().disable().authorizeHttpRequests()
              .requestMatchers("/" ).permitAll()
              .requestMatchers("/users").hasRole("USER")
              .anyRequest().authenticated()
              .and()
              .httpBasic().and().build();

  }
}
