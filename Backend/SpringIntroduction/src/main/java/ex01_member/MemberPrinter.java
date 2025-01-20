package ex01_member;

public class MemberPrinter {
    public void print(Member member) {
        System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
                member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
    }
}
