package member_annotation;

import ex01_member.Member;
import ex01_member.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("memberListPrinter")
public class MemberListPrinter {
    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    // @Qualifier("summaryPrinter")
    // private MemberPrinter printer;
    private MemberSummaryPrinter printer;

    // public MemberListPrinter(MemberDAO memberDAO, MemberPrinter printer) {
    //     this.memberDAO = memberDAO;
    //     this.printer = printer;
    // }

    public void printAll() {
        Collection<Member> members = memberDAO.selectAll();
        members.forEach(member -> printer.print(member));
    }
}
