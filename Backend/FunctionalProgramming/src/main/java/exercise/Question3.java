package exercise;

// Q3
// 다음과 같이 인터페이스 C와 클래스 J가 정의돼 있다.
//
@FunctionalInterface
interface C {
    double abc(int k);
}

class J {
    double bcd(int k) {
        return k * 0.1;
    }
}
//
// 이때 익명 이너 클래스 방법을 사용해 인터페이스 A 객체를 생성한 코드는 다음과 같다.
//
//         C c1 = new C() {
//             @Override
//             public double abc(int k) {
//                 J j = new J();
//                 return j.bcd(k);
//             }
//         };
//         System.out.println(a1.abc(100));    // 10.0
//
// 위의 코드를 인스턴스 메서드를 참조하는 람다식 문법을 사용해 변경하시오.

public class Question3 {
    public static void main(String[] args) {
        // 람다식
        C c2 = (k) -> {
            J j = new J();
            return j.bcd(k);
        };
        System.out.println(c2.abc(100));

        // 인스턴스 메서드 참조
        J j = new J();
        C a3 = j::bcd;
        System.out.println(a3.abc(100));

        // ?!?
        C a4 = new J()::bcd;
        System.out.println(a4.abc(100));
    }
}
