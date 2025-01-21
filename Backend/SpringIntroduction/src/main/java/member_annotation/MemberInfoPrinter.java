package member_annotation;

import ex01_member.Member;
import ex01_member.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Autowired 어노테이션을 setter 메서드에 붙이면, 스프링이 해당 setter 메서드를 통해 의존성을 주입

@Component("memberInfoPrinter") // ⇒ public MemberInfoPrinter infoPrinter() { return new MemberInfoPrinter(); }
public class MemberInfoPrinter {
    // @Autowired
    private MemberDAO memberDAO;

    // @Autowired 어노테이션도 @Qualifier 어노테이션이 없으면 필드나 파라미터 이름을 한정자로 사용
    // @Autowired
    private MemberPrinter printer; // ⇐ printer = 필드 이름 = 기본 한정자

    @Autowired
    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Autowired
    @Qualifier("printer")
    public void setMemberPrinter(MemberPrinter printer) {
        this.printer = printer;
    }


    public void printMemberInfo(String email) {
        Member member = memberDAO.selectByEmail(email);
        if (member == null) {
            System.out.println("일치하는 데이터가 없습니다.");
            return;
        }
        printer.print(member);
        System.out.println();
    }
}
