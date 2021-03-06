package com.codesoom.assignment.application;

import com.codesoom.assignment.domain.UserRepository;
import com.codesoom.assignment.utils.JwtUtil;
import io.jsonwebtoken.Claims;


import org.springframework.stereotype.Service;

/**
 *  인증에 관한 처리를 담당합니다.
 */
@Service
public class AuthenticationService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }


    public String login(String email, String password) {
        userRepository.findByEmail(email);
        return jwtUtil.encode(1L);
    }

    public Long parseToken(String accessToken) {
        Claims claims = jwtUtil.decode(accessToken);
        return claims.get("userId", Long.class);
    }


}
