package application;

// 매개변수 X, 반환값 O
@FunctionalInterface
interface XO {
    int method();   // 숫자 100을 반환
}

// 매개변수 O, 반환값 X
@FunctionalInterface
interface OX {
    void method(int i); // 매개변수에 10을 더한 수를 출력
}

// 매개변수 O, 반환값 O
@FunctionalInterface
interface OO {
    double method(int i, double d); // 매개변수 값들을 더한 결과를 반환
}

public class AnonymousClassExercise {
    public static void main(String[] args) {
        // 구현 클래스를 정의하고, 해당 클래스의 인스턴스를 이용해서 메서드를 호출
        class XOClass implements XO {
            @Override
            public int method() {
                return 100;
            }
        }
        XO xo1 = new XOClass();
        System.out.println(xo1.method());

        // 익명 이너 클래스를 정의해서 메서드를 호출
        XO xo2 = new XO() {
            @Override
            public int method() {
                return 100;
            }
        };
        System.out.println(xo2.method());

        // 람다 표현식
        XO xo3 = () -> 100;
        System.out.println(xo3.method());
        System.out.println();

        // 구현 클래스를 정의하고, 해당 클래스의 인스턴스를 이용해서 메서드를 호출
        class OXClass implements OX {
            @Override
            public void method(int i) {
                System.out.println(i + 10);
            }
        }
        OX ox1 = new OXClass();
        ox1.method(100);

        // 익명 이너 클래스를 정의해서 메서드를 호출
        OX ox2 = new OX() {
            @Override
            public void method(int i) {
                System.out.println(i + 10);
            }
        };
        ox2.method(100);

        // 람다 표현식
        OX ox3 = i -> System.out.println(i + 10);
        ox3.method(100);
        System.out.println();

        // 구현 클래스를 정의하고, 해당 클래스의 인스턴스를 이용해서 메서드를 호출
        class OOClass implements OO {
            @Override
            public double method(int i, double d) {
                return i + d;
            }
        }
        OO oo1 = new OOClass();
        System.out.println(oo1.method(100, 10.0));

        // 익명 이너 클래스를 정의해서 메서드를 호출
        OO oo2 = new OO() {
            @Override
            public double method(int i, double d) {
                return i + d;
            }
        };
        System.out.println(oo2.method(100, 10.0));

        // 람다 표현식
        OO oo3 = (i, d) -> i + d;
        System.out.println(oo3.method(100, 10.0));
    }
}
