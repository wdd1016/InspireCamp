package standardAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Predicate 함수형 인터페이스

// Predicate<T>		boolean test(T t)
// BiPredicate<T, U>	boolean test(T t, U u)
// DoublePredicate	boolean test(double v)
// IntPredicate		boolean test(int v)
// LongPredicate		boolean test(longv)

// 값(들)을 테스트(조사)

@AllArgsConstructor
@Getter
class Student {
    String name;
    String gender;
    int score;
}

public class PredicateInterfaces {

    private static List<Student> students = Arrays.asList(
            new Student("홍길동", "남자", 90),
            new Student("고길동", "남자", 91),
            new Student("나여자", "여자", 93),
            new Student("여자야", "여자", 92)
    );

    public static double average(Predicate<Student> pred) {
        int count = 0;
        int total = 0;
        for (Student student : students) {
            if (pred.test(student)) {
                count++;
                total += student.score;
            }
        }
        return (double) total / count;
    }

    public static void main(String[] args) {
        double maleAverage = average(t -> t.getGender().equals("남자"));
        System.out.println("남자 평균 점수 >>> " + maleAverage);

        double femaleAverage = average(t -> t.getGender().equals("여자"));
        System.out.println("여자 평균 점수 >>> " + femaleAverage);


        int count = 0;
        int total = 0;
        Predicate<Student> pred = new Predicate<>() {
            @Override
            public boolean test(Student t) {
                return t.getGender().equals("남자");
            }
        };
        for (Student student : students) {
            if (pred.test(student)) {
                count++;
                total += student.getScore();
            }
        }
        maleAverage = (double) total / count;
        System.out.println("남자 평균 점수 >>> " + maleAverage);
    }
}
