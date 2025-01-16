package stream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MapMethod {
    public static void main(String[] args) throws IOException {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 90), new Student("고길동", 80),
                new Student("일길동", 90), new Student("이길동", 80),
                new Student("삼길동", 90), new Student("사길동", 80));
        students.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);
    }
}
