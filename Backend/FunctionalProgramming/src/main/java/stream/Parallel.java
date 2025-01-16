package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Parallel {
    public static void print(Student s) {
        System.out.printf("[%s] %s : %d\n", Thread.currentThread().getName(), s.getName(), s.getScore());
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("홍길동", 90), new Student("고길동", 80),
                new Student("일길동", 90), new Student("이길동", 80),
                new Student("삼길동", 90), new Student("사길동", 80));

        // 순차 처리
        Stream<Student> stream = students.stream();
        stream.forEach(Parallel::print);

        System.out.println();

        // 병렬 처리
        Stream<Student> parallelStream = students.parallelStream();
        parallelStream.forEach(Parallel::print);

    }

}
