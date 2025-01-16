package stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
class Student {
    String name;
    int score;
}

public class Lombok {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("홍길동", 90), new Student("고길동", 80));

        System.out.println("for 문을 사용하여 출력:");
        for (Student student : students) {
            System.out.printf("%s : %d\n", student.getName(), student.getScore());
        }
        System.out.println(); // 빈 줄 추가

        System.out.println("Stream API를 사용하여 출력:");
        Stream<Student> stream = students.stream();
        stream.forEach(student -> System.out.printf("%s : %d\n", student.getName(), student.getScore()));
        System.out.println(); // 빈 줄 추가

        System.out.println("List.forEach() 메서드를 사용하여 출력:");
        // List.forEach() : List 인터페이스의 default method
        students.forEach(student -> System.out.printf("%s : %d\n", student.getName(), student.getScore()));
        System.out.println(); // 빈 줄 추가

    }
}
