package com.example.fitnessclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryUserDetailsConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // In-memory users for demonstration
        var admin = User.withUsername("admin").password("{noop}admin123").roles("ADMIN").build();
        var member = User.withUsername("member").password("{noop}member123").roles("MEMBER").build();
        var trainer = User.withUsername("trainer").password("{noop}trainer123").roles("TRAINER").build();
        return new InMemoryUserDetailsManager(admin, member, trainer);
    }
}