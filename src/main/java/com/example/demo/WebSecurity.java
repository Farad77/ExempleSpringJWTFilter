package com.example.demo;

	
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.utils.JwtRequestFilter;

@Configuration
public class WebSecurity {

	 @Autowired
	    private JwtRequestFilter jwtRequestFilter;
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeHttpRequests((authz) -> authz
	            		//.requestMatchers("/error*").permitAll()
	            		//.requestMatchers("/joueurs").permitAll()
	                .anyRequest().authenticated()
	            );
	            
	        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }

	
	/* @Bean
	 public PasswordEncoder passwordEncoder() {
	     return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 }
	    @Bean
	    public UserDetailsManager users(DataSource dataSource) {
	        UserDetails user = User.withDefaultPasswordEncoder()
	        	
	            .username("user")
	            .password("seb")
	            .roles("USER")
	            .build();
	       System.out.println(""+user.getPassword());
	        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
	     //   users.createUser(user);
	        return users;
	    }*/
}