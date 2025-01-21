package ex01_member.config;

import ex01_member.MemberDAO;
import ex01_member.MemberPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 빈의 개수가 증가하면 영역별로 설정 파일을 나누어서 관리하는 것이 편리

// @Import ⇒ 함께 사용할 설정 클래스를 지정

@Configuration
@Import(AppConf2.class)
// @Import({ AppConf2.class, AppConf3.class }) : @Import 어노테이션에 두 개 이상의 설정 클래스를 지정하는 경우
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
