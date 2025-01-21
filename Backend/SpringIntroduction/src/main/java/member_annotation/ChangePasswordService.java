package member_annotation;

import ex01_member.Member;
import ex01_member.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Autowired 어노테이션
// 사용 객체에서 의존 객체 필드에 @Autowired 어노테이션을 붙이면
// 스프링이 자동으로 해당 타입의 빈 객체를 찾아서 필드에 할당

@Component
public class ChangePasswordService {
    @Autowired
    private MemberDAO memberDAO;

    // public ChangePasswordService(MemberDAO memberDAO) { this.memberDAO = memberDAO; }

    public void changePassword(String email, String currentPassword, String newPassword) {
        Member member = memberDAO.selectByEmail(email);
        if (member == null) {
            throw new RuntimeException("등록된 회원이 없습니다");
        }
        member.changePassword(currentPassword, newPassword);
        memberDAO.update(member);
    }
}
