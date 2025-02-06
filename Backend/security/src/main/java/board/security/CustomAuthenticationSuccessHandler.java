package board.security;

import board.common.JwtUtils;
import board.entity.UserEntity;
import board.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private Environment env;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());

        // 토큰 발행 시간과 만료 시간 설정에 사용할 값
        Date now = new Date();
        Long expirationTime = Long.parseLong(env.getProperty("token.expiration-time"));

        // 서명에 사용할 키를 생성
        String secret = env.getProperty("token.secret");
        SecretKey hmacKey = Keys.hmacShaKeyFor(secret.getBytes());

        // JWT 토큰을 생성해서 로그로 기록
        /*
        String jwtToken = Jwts.builder()
                .claim("name", userEntity.getName())
                .claim("email", userEntity.getEmail())
                .subject(userEntity.getUsername() + "'s token")
                .id(String.valueOf(userEntity.getSeq()))
                .issuedAt(now)
                .expiration(new Date(now.getTime() + expirationTime))
                .signWith(hmacKey, Jwts.SIG.HS256)
                .compact();
        log.debug(jwtToken);
        */

        // jwtUtils 사용해서 JWT 토큰 생성
        String jwtToken = jwtUtils.generateToken(userEntity);
        response.setHeader("token", jwtToken);

        // request.getSession().setAttribute("user", userEntity);

        // UI 사용시에 필요
        // response.sendRedirect("/");
    }
}
