package stream;

// flatMap은 각 요소에 대해 Function을 적용하고, 결과로 생성된 여러 스트림을 하나의 스트림으로 병합합니다.
// 중첩된 구조를 하나의 단일 스트림으로 변환하여 다루기 쉽게 만들어줍니다.

import java.util.Arrays;
import java.util.List;

public class FlatMapMethod {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("java8 lambda", "stream mapping api");
        list1.stream()
                .flatMap(d -> Arrays.stream(d.split(" ")))
                .forEach(System.out::println);
        System.out.println();

        List<String> list2 = Arrays.asList("10, 20, 30, 40, 50, 60");
        list2.stream()
                .flatMapToInt(d -> {
                    String[] strArray = d.split(",");
                    int[] intArray = new int[strArray.length];
                    for (int i = 0; i < strArray.length; i++) {
                        intArray[i] = Integer.parseInt(strArray[i].trim());
                    }
                    return Arrays.stream(intArray);
                })
                .forEach(System.out::println);
    }
}
