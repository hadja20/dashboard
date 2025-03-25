package com.qpc.dashboard.service;

import com.qpc.dashboard.models.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class TokenService {

    private final JwtEncoder encoder;

    public TokenService(JwtEncoder encoder) {
        this.encoder = encoder;
    }


    public String generateToken(Authentication authentication){
        Instant now=Instant.now();
        String scope=authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(""));
        SecurityUser user = (SecurityUser) authentication.getPrincipal();

        JwtClaimsSet claims=JwtClaimsSet.builder()
                .subject(String.format("%s,%s, %s", user.getId(), user.getUsername(), user.getEmail()))
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .claim("scope",scope)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

    }
}
