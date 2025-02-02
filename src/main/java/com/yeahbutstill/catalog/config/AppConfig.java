package com.yeahbutstill.catalog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeahbutstill.catalog.security.util.JWTTokenFactory;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Key;

@Configuration
public class AppConfig {

    @Bean
    public Key key() {
        byte[] keyBytes = Decoders.BASE64.decode("021kdasjkjsdaiwqueioewuq1292813021938123qwdsasdawqewq2121");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Bean
    public JWTTokenFactory jwtTokenFactory(Key key) {
        return new JWTTokenFactory(key);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
