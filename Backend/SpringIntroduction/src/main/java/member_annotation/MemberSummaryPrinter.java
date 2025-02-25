package member_annotation;

import ex01_member.Member;

public class MemberSummaryPrinter extends MemberPrinter {
    @Override
    public void print(Member member) {
        System.out.printf("회원정보: 이메일=%s, 이름=%s\n", member.getEmail(), member.getName());
    }
}
