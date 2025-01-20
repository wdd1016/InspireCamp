package ex01_member.main;

import ex01_member.Member;
import ex01_member.MemberDAO;
import ex01_member.MemberPrinter;

import java.util.Collection;

public class MemberListPrinter {
    private MemberDAO memberDAO;
    private MemberPrinter printer;

    public MemberListPrinter(MemberDAO memberDAO, MemberPrinter printer) {
        this.memberDAO = memberDAO;
        this.printer = printer;
    }

    public void printAll() {
        Collection<Member> members = memberDAO.selectAll();
        members.forEach(member -> printer.print(member));
    }
}
