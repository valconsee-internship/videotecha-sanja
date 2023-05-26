package com.project.videotecha.service.impl;

import com.project.videotecha.model.User;
import com.project.videotecha.service.TokenService;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenServiceImpl implements TokenService {

    private final JwtEncoder encoder;

    public TokenServiceImpl(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateToken(User user) {
        Instant now = Instant.now();
        String role = user.getUserType().name();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("videotecha")
                .issuedAt(now)
                .expiresAt(now.plus(30, ChronoUnit.MINUTES))
                .subject(user.getEmail())
                .claim("role", role)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
