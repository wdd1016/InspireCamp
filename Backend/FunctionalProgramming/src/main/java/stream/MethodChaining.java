package stream;

import java.util.Arrays;
import java.util.List;

public class MethodChaining {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 90), new Student("고길동", 80),
                new Student("일길동", 90), new Student("이길동", 80),
                new Student("삼길동", 90), new Student("사길동", 80));

        double average = students.stream()
                .mapToInt(Student::getScore)    // 학생의 점수를 맵핑
                .average()
                .getAsDouble();
        System.out.println(average);
    }
}
