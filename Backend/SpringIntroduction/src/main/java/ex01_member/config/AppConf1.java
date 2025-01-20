package ex01_member.config;

// 빈의 개수가 증가하면 영역별로 설정 파일을 나누어서 관리하는 것이 편리

import ex01_member.MemberDAO;
import ex01_member.MemberPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf1 {
    @Bean
    public MemberDAO memberDAO() {
        return new MemberDAO();
    }

    // 추가
    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }
}
