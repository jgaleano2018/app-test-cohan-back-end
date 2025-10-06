package com.cohan.test.config;

/*import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http
	         .csrf(csrf -> csrf.disable())
	         .authorizeHttpRequests(auth -> auth
	             .requestMatchers("/auth/**").permitAll()
	             .anyRequest().authenticated()
	         )
	         .oauth2ResourceServer(oauth2 -> oauth2
	             .jwt(Customizer.withDefaults())
	         );
	            		
	        return http.build();
	    }
}*/


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for API-only applications
            .authorizeHttpRequests(authorize -> authorize
            	.requestMatchers("/**").permitAll()
                //.anyRequest().authenticated() // All other requests require authentication
            )
            .httpBasic(withDefaults()); // Enable HTTP Basic authentication
        return http.build();
    }
}




