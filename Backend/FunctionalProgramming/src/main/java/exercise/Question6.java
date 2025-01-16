package exercise;

// 3개의 생성자가 오버로딩된 클래스 F는 다음과 같다.

class F {
    F() {
        System.out.println("첫번째 생성자");
    }

    F(int a) {
        System.out.println("두번째 생성자");
    }

    F(int a, double b) {
        System.out.println("세번째 생성자");
    }
}

// 클래스 생성자 참조 람다식을 사용해 x의 객체를 생성하고,
// X객체의 abc() 메서드를 호출했을 때 "세번째 생성자"가 출력될 수 있도록
// 인터페이스 X를 작성하시오.

// X x1 = F::new;
// x1.abc(1, 2.0);	// 세번째 생성자

@FunctionalInterface
interface X {
    F abc(int a, double b);
}

public class Question6 {
    public static void main(String[] args) {
        X x1 = F::new;
        x1.abc(1, 2.0);

        X x2 = new X() {
            @Override
            public F abc(int a, double b) {
                return new F(a, b);
            }
        };
        x2.abc(1, 2.0);
    }
}
