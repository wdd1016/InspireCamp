package standardAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

// Function 함수형 인터페이스 ⇒ 매개변수와 리턴값이 있는 applyXXX() 메서드를 포함

// public interface Function<T, R> 		    ⇒ R apply<T t>
// public interface BiFunction<T, U, R>		⇒ R apply<T t, U u>
// public interface DoubleFunction<R>		⇒ R apply(double value)
// public interface IntFunction<R>		    ⇒ R apply(int value)
// public interface LongFunction<R>		    ⇒ R apply(long value)
// public interface IntToLongFunction		⇒ long applyAsLong(int value)
// public interface ToIntFunction<T>		⇒ int applyAsInt(T t)

@AllArgsConstructor
@Getter
class Learner {
    private String name;
    private int englishScore;
    private int mathScore;
}

public class FunctionInterfaces {
    private static List<Learner> list = Arrays.asList(
            new Learner("홍길동", 90, 96),
            new Learner("고길동", 85, 90)
    );

    // 함수형 인터페이스를 매개변수로 넣는다.
    public static void printString(Function<Learner, String> function) {
        for (Learner student : list) {
            System.out.print(function.apply(student) + "    ");
        }
        System.out.println();
    }

    public static void printInt(ToIntFunction<Learner> function) {
        for (Learner student : list) {
            System.out.print(function.applyAsInt(student) + "       ");
        }
        System.out.println();
    }

    public static double average(ToIntFunction<Learner> function) {
        int sum = 0;
        for (Learner student : list) {
            sum += function.applyAsInt(student);
        }
        return (double) sum / list.size();
    }

    public static void main(String[] args) {
        // 학생이름     홍길동     고길동
        // 영어점수     90          85
        // 수학점수     96          90
        // 영어평균     87.5
        // 수학평규     93.0

        System.out.print("학생이름\t");
        // Function<Learner, String> function : t -> t.getName()
        printString(t -> t.getName());

        System.out.print("영어점수\t");
        printInt(t -> t.getEnglishScore());

        System.out.print("수학점수\t");
        printInt(t -> t.getMathScore());

        System.out.print("영어평균\t");
        System.out.println(average(t -> t.getEnglishScore()));

        System.out.print("수학평균\t");
        System.out.println(average(t -> t.getMathScore()));
    }
}
