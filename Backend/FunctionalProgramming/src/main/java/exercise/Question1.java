package exercise;

// Q1

// 다음은 함수형 인터페이스 A의 객체를 익명 이너 클래스 방법으로 생성한 후 메서드를 호출한 코드다. 이를 람다식 코드로 변경하시오. (단, 람다식의 약식 표현은 사용하지 말 것)
//         A a = new A() {
//             public void abc(double k) {
//                 System.out.println(k + 0.5);
//             }
//         };
//         a.abc(3.8);

@FunctionalInterface
interface A {
    void abc(double k);
}

public class Question1 {
    public static void main(String[] args) {
        // 익명 이너 클래스
        A a1 = (double k) -> {
            System.out.println(k + 0.5);
        };
        a1.abc(3.8);

        // 람다식
        A a2 = k -> System.out.println(k + 0.5);
        a2.abc(3.8);
    }
}
