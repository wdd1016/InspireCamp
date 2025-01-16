package standardAPI;

import java.util.function.IntBinaryOperator;

// Operator 함수형 인터페이스

// public interface BinaryOperator<T>		T apply(T t1, T t2)
// public interface UnaryOperator<T>		T apply(T t)

// public interface DoubleBinaryOperator	double applyAsDouble(double left, double right)
// public interface DoubleUnaryOperator		double applyAsDouble(double value)

// public interface IntBinaryOperator		int applyAsInt(int left, int right)
// public interface IntUnaryOperator		int applyAsInt(int value)

public class OperatorGroup {
    private static int[] scores = {92, 95, 87};

    public static int maxOrMin(IntBinaryOperator op) {
        int result = scores[0];
        for (int score : scores) {
            result = op.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        int max = maxOrMin((a, b) -> {
            if (a >= b) return a;
            else return b;
        });
        System.out.println("최대값 >>> " + max);

        int min = maxOrMin((a, b) -> {
            if (a <= b) return a;
            else return b;
        });
        System.out.println("최소값 >>> " + min);


        IntBinaryOperator maxOp = (a, b) -> {
            if (a >= b) return a;
            else return b;
        };
        int result = scores[0];
        for (int score : scores) {
            result = maxOp.applyAsInt(result, score);
        }
        System.out.println("최대값 >>> " + result);


        IntBinaryOperator minOp = (a, b) -> {
            if (a <= b) return a;
            else return b;
        };
        result = scores[0];
        for (int score : scores) {
            result = minOp.applyAsInt(result, score);
        }
        System.out.println("최소값 >>> " + result);
    }
}
