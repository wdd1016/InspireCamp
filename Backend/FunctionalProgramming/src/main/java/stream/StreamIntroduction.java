package stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

// 자바8 추가된 컬렉션(배열 포함)의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해 주는 반복자
// Iterator: 명령형, Stream: 선언형

public class StreamIntroduction {
    public static void main(String[] args) {
        List<String> lists = Arrays.asList("aaa", "bbb", "ccc");

        // Iterator
        System.out.println("1. Iterator를 사용하여 출력:");
        Iterator<String> it = lists.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }
        System.out.println();

        // Stream
        System.out.println("2. Stream (람다식)을 사용하여 출력:");
        Stream<String> st = lists.stream();
        st.forEach(item -> System.out.println(item));
        System.out.println();

        System.out.println("3. Stream (메서드 참조)을 사용하여 출력:");
        st = lists.stream();
        st.forEach(System.out::println);
        System.out.println();

        // 람다식 또는 메서드 참조로 요소 처리 코드를 제공
        System.out.println("4. Stream을 사용하여 대문자로 변환 후 출력:");
        lists.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println();
    }
}
