package member_annotation.config;

import ex01_member.MemberDAO;
import ex01_member.MemberRegisterService;
import ex01_member.VersionPrinter;
import member_annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Spring bean이 어떻게 만들어질지 결정
@Configuration
@ComponentScan(basePackages = {"member_annotation", "member_next"})
public class AppContext {
    // 자동으로 등록되는 빈과 동일한 이름의 빈을 설정 클래스에서 등록하면
    // 문제없음 ⇒ 수동으로 등록한 빈이 사용됨
    @Bean
    public MemberDAO memberDAO() {
        System.out.println("MemberDAO() Manual Bean Called");
        return new MemberDAO();
    }

    // @Bean
    // public MemberRegisterService memberRegisterService() { return new MemberRegisterService(memberDAO()); }
    //
    // @Bean
    // public ChangePasswordService changePasswordService() { return new ChangePasswordService(); }

    // 자동 주입 가능한 빈이 두 개 이상이면 자동 주입할 빈을 지정할 방법이 필요
    // ⇒ @Qualifier 어노테이션을 이용해서 자동 주입 대상 빈을 한정
    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

/*
    // 빈 설정에 @Qualifier 어노테이션을 사용하지 않으면 빈 이름이 기본 한정자로 지정
    @Bean
    public MemberPrinter memberPrinter2() { // ⇐ memberPrinter2 = 빈 이름 = 기본 한정자
        return new MemberPrinter();
    }
*/

    @Bean
    // @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2() {        // 기존의 memberPrinter2 메서드를 수정
        return new MemberSummaryPrinter();
    }

    // @Bean
    // public MemberListPrinter memberListPrinter() {
    //     return new MemberListPrinter();
    // }
    //
    // @Bean
    // public MemberInfoPrinter memberInfoPrinter() {
    //     MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
    //     // infoPrinter.setMemberDAO(memberDAO());
    //     // infoPrinter.setPrinter(memberPrinter());
    //     return infoPrinter;
    // }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(3);
        return versionPrinter;
    }
}
