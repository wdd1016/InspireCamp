package ex01_member;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// Data Access Object
@Component
public class MemberDAO {
    private static long nextId = 0;

    // 키: 이메일, 값: Member
    private Map<String, Member> map = new HashMap<>();

    // 조회
    public Member selectByEmail(String email) {
        return map.get(email);
    }

    // 등록
    public void insert(Member member) {
        member.setId(++nextId);
        map.put(member.getEmail(), member);
    }

    // 수정
    public void update(Member member) {
        map.put(member.getEmail(), member);
    }

    // 전체 조회
    public Collection<Member> selectAll() {
        return map.values();
    }
}
