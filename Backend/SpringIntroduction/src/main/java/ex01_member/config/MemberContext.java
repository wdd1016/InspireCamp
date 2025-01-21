package ex01_member.config;

import ex01_member.*;
import ex01_member.main.MemberInfoPrinter;
import ex01_member.main.MemberListPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring bean이 어떻게 만들어질지 결정
@Configuration
public class MemberContext {
    @Bean
    public MemberDAO memberDAO() {
        return new MemberDAO();
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDAO());
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        return new ChangePasswordService(memberDAO());
    }

    // 추가
    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter(memberDAO(), memberPrinter());
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDAO(memberDAO());
        infoPrinter.setPrinter(memberPrinter());
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(3);
        return versionPrinter;
    }
}
