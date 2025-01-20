package ex01_member.assembler;

import ex01_member.ChangePasswordService;
import ex01_member.MemberDAO;
import ex01_member.MemberRegisterService;
import lombok.Getter;

@Getter
public class Assembler {
    private MemberDAO memberDAO;
    private MemberRegisterService registerService;
    private ChangePasswordService passwordService;

    public Assembler() {
        this.memberDAO = new MemberDAO();
        this.registerService = new MemberRegisterService(this.memberDAO);
        this.passwordService = new ChangePasswordService(this.memberDAO);
    }
}
