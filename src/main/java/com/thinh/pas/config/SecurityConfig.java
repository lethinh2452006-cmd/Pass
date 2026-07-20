package com.thinh.pas.config;


import com.thinh.pas.filters.userprovisioningfilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterchain (HttpSecurity http,
                                            userprovisioningfilter userprovisioningfilter) throws Exception{
        http.authorizeHttpRequests(authorize ->
                authorize.anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2->
                        oauth2.jwt(
                                Customizer.withDefaults()
                        ))
                .addFilterAfter(userprovisioningfilter, BearerTokenAuthenticationFilter.class);
        return http.build();
    }
}
