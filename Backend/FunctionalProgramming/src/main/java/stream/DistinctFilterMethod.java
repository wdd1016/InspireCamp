package stream;

import java.util.Arrays;
import java.util.List;

public class DistinctFilterMethod {
    public static void main(String[] args) {
        List<String> stations = Arrays.asList("부평시장", "홍대입구", "강남", "신도림", "역삼", "삼성", "신림", "부평구청", "신도림");

        stations.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        stations.stream()
                .filter(s -> s.startsWith("신"))
                .forEach(System.out::println);

        System.out.println();

        stations.stream()
                .filter(s -> s.startsWith("신"))
                .distinct()
                .forEach(System.out::println);
    }

}
