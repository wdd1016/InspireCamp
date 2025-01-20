package ex01_member.config;

import ex01_member.ChangePasswordService;
import ex01_member.MemberDAO;
import ex01_member.MemberRegisterService;
import ex01_member.VersionPrinter;
import ex01_member.MemberPrinter;
import ex01_member.main.MemberInfoPrinter;
import ex01_member.main.MemberListPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf2 {
    // 스프링 빈을 자동으로 주입
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private MemberPrinter memberPrinter;

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDAO);
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        return new ChangePasswordService(memberDAO);
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter(memberDAO, memberPrinter);
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDAO(memberDAO);
        infoPrinter.setPrinter(memberPrinter);
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        // versionPrinter.setMajorVersion(5);
        // versionPrinter.setMinorVersion(3);
        return versionPrinter;
    }
}
