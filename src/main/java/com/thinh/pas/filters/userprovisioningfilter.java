package com.thinh.pas.filters;


import com.thinh.pas.domain.entities.users;
import com.thinh.pas.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt; import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class userprovisioningfilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        @Nullable Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null
                && authentication.isAuthenticated()
                && authentication.getPrincipal() instanceof Jwt jwt ){

            UUID keycloak_id = UUID.fromString(jwt.getSubject());

            if(!userRepository.existsById(keycloak_id)){

                users users = new users();
                users.setId(keycloak_id);

                userRepository.save(users);
            }

        }

        filterChain.doFilter(request, response);
    }

}
