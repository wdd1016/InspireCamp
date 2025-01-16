package stream;

import java.util.stream.IntStream;

public class StreamRange {
    public static int sum = 0;

    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1, 100);   // 1 ~ 100
        stream.forEach(n -> sum += n);
        System.out.println(sum);

        sum = 0;
        IntStream stream2 = IntStream.range(1, 100);        // 1 ~ 99
        stream2.forEach(n -> sum += n);
        System.out.println(sum);
    }
}
