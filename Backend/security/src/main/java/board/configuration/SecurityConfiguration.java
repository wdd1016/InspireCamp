package board.configuration;

import board.security.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    CustomAuthenticationSuccessHandler successHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/home", "/join", "/joinProc").permitAll()
                .requestMatchers("/board/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/admin").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
        );
        http.formLogin(auth -> auth
                .loginPage("/login")
                .loginProcessingUrl("/loginProc")
                .permitAll()
                // .defaultSuccessUrl("/board")
                .successHandler(successHandler)
        );

        // 403 Forbidden 발생 시, main 페이지로 리다이렉트
        http.exceptionHandling(exception ->
                exception.accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.sendRedirect("/?accessDenied=true");
                })
        );

        // 개발단계에서 임시적으로 disable
        http.csrf(auth -> auth.disable());

        return http.build();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

