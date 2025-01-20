package ex01;

import lombok.Getter;

// 의존(dependency)
// 한 클래스가 다른 클래스의 메서드를 사용(실행)할 때 의존한다라고 표현
// ⇒ 변경에 의해 영향을 받는 관계

// MemberExampleRegisterService는 MemberExampleDAO의 selectByEmail 메서드와 insert 메서드를 사용하고 있다. ⇒ 의존한다.
// ⇒ MemberExampleDAO의 selectByEmail 메서드 또는 insert 메서드를 변경하면 MemberExampleRegisterService도 변경이 필요
class MemberExampleRegisterService {
    private MemberExampleDAO dao = new MemberExampleDAO();

    public void regist(MemberExample member) throws Exception {
        MemberExample m = dao.selectByEmail(member.getEmail());
        if (m != null) {
            throw new Exception("이메일이 중복되었습니다.");
        }
        dao.insert(member);
    }
}

// 의존 객체를 구하는 방법
//
// 방법1. 의존 대상 객체를 직접 생성
//
// public class MemberExampleRegisterService {
// 	private MemberExampleDAO dao = new MemberExampleDAO();
// 		:
//
// ⇒ 구현은 용이하나, 유지보수에 문제가 있음
//
//
// 방법2. DI(Dependency Injection, 의존 주입)
//
// 의존하는 객체를 직접 생성하는 대신, 의존 객체를 전달받는 방식
//
// public class MemberExampleRegisterService {
// 	private MemberExampleDAO dao;
//
// 	public MemberExampleRegisterService(MemberExampleDAO dao) {
// 		this.dao = dao;
// 	}

// 의존 객체를 주입해 주는 곳만 수정하면 변경을 반영할 수 있음
//
//
// class Main {
// 	public static void main(String[] args) {
// 		MemberDAO dao1 = new MemberDAO();
// 		MemberRegisterService mrs1 = new MemberRegisterService(dao1);
//
// 		MemberDAO dao2 = new NewMemberDAO();
// MemberRegisterService mrs2 = new MemberRegisterService(dao2);
// 	}
// }
//
// class NewMemberDAO extends MemberDAO {
// 		:
// }

class MemberExampleDAO {
    // 이메일 정보가 일치하는 사용자 정보를 조회해서 반환
    public MemberExample selectByEmail(String email) {
        return null;
    }

    // 회원 정보를 저장
    public void insert(MemberExample member) {
        // TODO
    }
}

@Getter
class MemberExample {
    String id;
    String email;
}
