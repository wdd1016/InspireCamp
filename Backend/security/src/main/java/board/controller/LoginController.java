package board.controller;

import board.common.JwtUtils;
import board.dto.CustomUserDetails;
import board.dto.LoginRequest;
import board.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/loginProc")
    public ResponseEntity<?> loginProc(@RequestBody LoginRequest loginRequest) {
        try {
            // 인증 시도
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            // 인증 성공 후 사용자 정보 로드 및 토큰 생성
            UserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(loginRequest.getUsername());
            String jwtToken = jwtUtils.generateToken(userDetails);

            return ResponseEntity.ok(jwtToken);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "아이디 또는 비밀번호가 올바르지 않습니다."));
        }
    }

    // @GetMapping("/login")
    // public String login() {
    //     return "/login";
    // }
}
