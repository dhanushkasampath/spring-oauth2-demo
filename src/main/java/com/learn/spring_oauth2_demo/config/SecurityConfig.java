package com.learn.spring_oauth2_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())// this line restricts the access to resources
            .oauth2Login(Customizer.withDefaults()); // this line specifies that, "hey... I want to use oauth2 for login"

        //in thi world google is not the only oauth2 provider. there are lot. So we need to pass which login we have to go for.
        // That can be specified in application.properties.
        return httpSecurity.build();
    }
}
