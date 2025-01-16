package standardAPI;

import java.util.function.IntSupplier;

// Supplier 함수형 인터페이스 ⇒ getXXX() 메서드를 포함

// public interface Supplier<T> 	T get();
// public interface BooleanSupplier	boolean getAsBoolean()
// public interface DoubleSupplier	double getAsDouble()
// public interface IntSupplier		int getAsInt()
// public interface LongSupplier	long getAsLong()

class Dice {
    static int getNumber() {
        return (int) (Math.random() * 6) + 1;
    }
}

public class SupplierInterfaces {
    public static void main(String[] args) {
        // 기존 클래스 방식
        System.out.println("주사위 결과 >>> " + Dice.getNumber());

        // 익명 이너 클래스
        IntSupplier intSupplier1 = new IntSupplier() {
            @Override
            public int getAsInt() {
                return (int) (Math.random() * 6) + 1;
            }
        };
        System.out.println("주사위 결과 >>> " + intSupplier1.getAsInt());

        // 람다식
        IntSupplier intSupplier2 = () -> (int) (Math.random() * 6) + 1;
        System.out.println("주사위 결과 >>> " + intSupplier2.getAsInt());
    }
}
