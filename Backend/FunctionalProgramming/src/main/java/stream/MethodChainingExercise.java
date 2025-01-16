package stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
class Member {
    public static int MALE = 0;
    public static int FEMALE = 1;

    private String name;
    private int gender;
    private int age;
}

public class MethodChainingExercise {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("홍길동", Member.MALE, 30),
                new Member("고길동", Member.MALE, 40),
                new Member("이하니", Member.FEMALE, 20),
                new Member("삼하니", Member.FEMALE, 30));
        ;

        double maleAvgAge = members.stream()
                .filter(m -> m.getGender() == Member.MALE)
                // .mapToInt(m -> m.getAge())
                .mapToInt(Member::getAge)
                .average()
                .getAsDouble();

        System.out.println("남자 평균 나이 : " + maleAvgAge);
    }

}
