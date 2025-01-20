package ex01_member.main;

import ex01_member.Member;
import ex01_member.MemberDAO;
import ex01_member.MemberPrinter;
import lombok.Setter;

@Setter
public class MemberInfoPrinter {
    private MemberDAO memberDAO;
    private MemberPrinter printer;

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
