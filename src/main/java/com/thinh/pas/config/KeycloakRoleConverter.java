package com.thinh.pas.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private final JwtGrantedAuthoritiesConverter defaultAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    @SuppressWarnings("unchecked")
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // Lấy các authority mặc định từ scope (ví dụ SCOPE_email, SCOPE_profile)
        Collection<GrantedAuthority> defaultAuthorities = defaultAuthoritiesConverter.convert(jwt);

        // Lấy thông tin realm_access chứa roles từ Keycloak Token
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        if (realmAccess == null || realmAccess.isEmpty()) {
            return defaultAuthorities;
        }

        Collection<String> roles = (Collection<String>) realmAccess.get("roles");
        if (roles == null) {
            return defaultAuthorities;
        }

        // Ánh xạ các role của Keycloak sang định dạng ROLE_ đại diện cho Spring Security Authority
        Collection<GrantedAuthority> keycloakAuthorities = roles.stream()
                .map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // Gộp các authority mặc định (scope) và keycloak roles
        if (defaultAuthorities == null) {
            return keycloakAuthorities;
        }
        return Stream.concat(defaultAuthorities.stream(), keycloakAuthorities.stream())
                .collect(Collectors.toSet());
    }
}
