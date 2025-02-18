package board.configuration;

// import board.security.CustomAuthenticationSuccessHandler;

import board.security.JwtRequestFilter;
import board.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    // @Autowired
    // CustomAuthenticationSuccessHandler successHandler;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                // .requestMatchers("/", "/login", "/home", "/join", "/joinProc").permitAll()
                // .requestMatchers("/board/**").hasAnyRole("ADMIN", "USER")
                // .requestMatchers("/admin").hasAnyRole("ADMIN")
                .requestMatchers("/loginProc", "/joinProc").permitAll()
                .requestMatchers("/api/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
        );

        // http.formLogin(auth -> auth
        //         .loginPage("/login")
        //         .loginProcessingUrl("/loginProc")
        //         .permitAll()
        //         // .defaultSuccessUrl("/board")
        //         .successHandler(successHandler)
        // );
        http.formLogin(auth -> auth.disable());

        // 403 Forbidden 발생 시, main 페이지로 리다이렉트
        // http.exceptionHandling(exception ->
        //         exception.accessDeniedHandler((request, response, accessDeniedException) -> {
        //             response.sendRedirect("/?accessDenied=true");
        //         })
        // );

        // 개발단계에서 임시적으로 disable
        http.csrf(auth -> auth.disable());


        // 세션을 유지 (UI)
        // http.sessionManagement(auth -> auth
        //         // changeSessionId() : 기본값. 현재 세션 ID를 새 세션 ID로 변경 (기존 세션 속성은 그대로 유지)
        //         // newSession()      : 새 세션을 생성하고 기존 세션은 무효화 (기존 세션 속성은 복사되지 않음)
        //         // migrateSession()  : 새 세션을 생성하고 기존 세션의 속성을 새 세션으로 복사 (기존 세션은 무효화 처리)
        //         // none()            : 세션 고정을 방어할 수 없음 (권장하지 않음)
        //         .sessionFixation(ses -> ses.newSession())
        //         // maximumSessions(int)              : 하나의 아이디에 대해 다중 로그인 허용 개수
        //         // maxSessionsPreventsLogin(boolean) : 다중 로그인 개수를 초과한 경우 처리 방법
        //         // - true  : 초과 시 새로운 로그인을 차단
        //         // - false : 초과 시 기존 세션 하나를 삭제
        //         .maximumSessions(1)
        //         .maxSessionsPreventsLogin(true)
        // );

        // 세션 less (API)
        http.sessionManagement(auth -> auth.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // CSRF 기능을 차단하면 POST 방식으로 로그아웃을 해야 하므로,
        // 만약 GET 방식으로 로그아웃을 처리하려면 아래와 같은 설정을 추가해야 함 ⇒ SecurityConfiguration
        // http.logout(auth -> auth.logoutUrl("/logout").logoutSuccessUrl("/"));
        http.logout(auth -> auth.disable());

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        http.cors(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 사용자 인증을 담당
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
        return authManagerBuilder.build();
    }
}

