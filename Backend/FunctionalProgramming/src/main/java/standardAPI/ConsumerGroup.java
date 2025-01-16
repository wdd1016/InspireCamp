package standardAPI;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

// Consumer 계열
// public interface Consumer<T> 		    void accept(T t)
// public interface BiConsumer<T, U>		void accept(T t, U u)
// public interface DoubleConsumer		    void accept(double value)
// public interface LongConsumer		    void accept(long value)
// public interface ObjDoubleConsumer<T>	void accept(T t, double value)
// public interface ObjIntConsumer<T> 		void accept(T t, int value)
// public interface ObjLongConsumer<T> 		void accept(T t, long value)

public class ConsumerGroup {
    public static void main(String[] args) {
        // 익명 이너 클래스
        Consumer<String> consumer1 = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.printf("%s's length is %d\n", s, s.length());
            }
        };
        consumer1.accept("Hello, Consumer");

        // 람다식
        Consumer<String> consumer2 = s -> System.out.printf("%s's length is %d\n", s, s.length());
        consumer2.accept("Hello, Consumer");

        BiConsumer<String, Integer> consumer3 = (s, i) -> System.out.printf("이름은 %s이고, 나이는 %d입니다.\n", s, i);
        consumer3.accept("홍길동", 23);

        DoubleConsumer consumer4 = d -> System.out.printf("Java version is %.2f\n", d);
        consumer4.accept(11.2);

        ObjIntConsumer<String> consumer5 = (o, i) -> System.out.printf("%s의 나이는 %d 입니다.\n", o, i);
        consumer5.accept("홍길동", 23);
    }
}
