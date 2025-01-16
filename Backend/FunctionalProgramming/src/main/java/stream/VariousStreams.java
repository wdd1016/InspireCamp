package stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VariousStreams {
    public static void main(String[] args) {
        String[] strArr = {"홍길동", "고길동", "신길동"};

        Stream<String> strStm = Arrays.stream(strArr);
        strStm.forEach(s -> System.out.println(s));
        System.out.println();

        strStm = Arrays.stream(strArr);
        strStm.forEach(System.out::println);
        System.out.println();

        int[] intArr = {10, 20, 30};
        IntStream intStm = Arrays.stream(intArr);
        intStm.forEach(s -> System.out.println(s));
    }
}
