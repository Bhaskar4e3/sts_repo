package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
   @Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return    http.authorizeHttpRequests(registry->{
    	    registry.requestMatchers("/home/**").permitAll();
        	registry.requestMatchers("/user/**").hasRole("USER");
        	registry.requestMatchers("/admin/**").hasRole("ADMIN");
        	registry.anyRequest().authenticated();
        }).formLogin(formlogin->formlogin.permitAll()).build();
	}
   @Bean
   UserDetailsService userDetailsService() {
	   UserDetails bhaskar=User.builder().
			   username("bhaskar").
			   password(passwordEncoder().encode("bhaskar")).
			   roles("USER").build();
	   UserDetails user=User.builder()
	                    .username("ADMIN")
	                    .password(passwordEncoder().encode("ADMIN"))
	                    .roles("ADMIN","USER")
	                    .build();
	return new InMemoryUserDetailsManager(bhaskar,user);
	   
   }
    

}
