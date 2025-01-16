package exercise;

// Q5
// 다음 코드는 배열 생성자 참조를 이용한 람다식으로 인터페이스 E의 객체를 생성하는 코드다.
// 인터페이스 E를 작성하시오. (추상메서드의 이름은 abc)
//
// 	E e1 = double[]::new;

@FunctionalInterface
interface E {
    double[] abc(int len);
}

public class Question5 {
    public static void main(String[] args) {
        E e2 = new E() {
            @Override
            public double[] abc(int len) {
                return new double[len];
            }
        };

        E e1 = double[]::new;

        e1.abc(1);
        e2.abc(1);
    }
}

