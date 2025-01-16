package exercise;

@FunctionalInterface
interface B {
    int abd(String str);
}

// Q2
// 다음과 같이 함수형 인터페이스 B가 정의돼 있다.
// 다음의 람다식을 이용한 객체 생성 코드를 익명 이너 클래스를 이용한 객체 생성 코드로 바꿔 작성하시오.
// 	B b1 = str -> str.length();
//  System.out.println(b1.abd("Hello, Lambda")); // 13

public class Question2 {
    public static void main(String[] args) {
        // 익명 이너 클래스
        B b2 = new B() {
            @Override
            public int abd(String str) {
                return str.length();
            }
        };
        System.out.println(b2.abd("Hello, Lambda"));

        // 메소드 참조
        B b3 = String::length;
        System.out.println(b3.abd("Hello, Lambda"));
    }
}
