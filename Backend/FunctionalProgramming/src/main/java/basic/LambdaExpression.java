package basic;

// 람다식
// 객체지향 언어인 자바에서 함수형 프로그래밍 기법을 지원하는 자바의 문법
// 간결하게 코드 블록을 작성할 수 있는 표현 방법으로, 주로 함수형 인터페이스와 함께 사용
// 자바는 새로운 함수 문법을 정의하는 대신, 이미 있는 인터페이스의 문법을 활용해서 람다식을 표현

// (매개변수) -> { 코드블록 }

// 기존
// void abc() { ... }
// abc();
//
// 인스턴스 만들고 호출 필요
// class A { void abc() { ... }; }
// A a = new A();
// a.abc();

// 함수형 인터페이스(functional interface) 사용

// Lambda Expression

// 매개변수와 리턴값이 없는 경우
// void method() { System.out.println("hello"); }
// () -> { System.out.println("hello"); }
// () -> System.out.println("hello");

// 매개변수는 있고, 리턴값이 없는 경우
// void method(int i) { System.out.println(i); }
// (int i) -> { System.out.println(i); }
// i -> System.out.println(i);

// 매개변수는 없고, 리턴값이 있는 경우
// int method() { return 100; }
// () -> { return 100; }
// () -> 100;

// 매개변수와 반환값이 모두 있는 경우
// int method(int a, int b) { return a + b; }
// (int a, int b) -> { return a + b; }
// (a, b) -> a + b;

// 매개변수 타입 생략이 가능하고, 매개변수가 1개일 때는 () 생략이 가능
// A a1 = (int a) -> { .... };
// A a2 = (a) -> { .... };
// A a3 = a -> { .... };
// !안됨! A a2 = int a -> { .... };   ⇐ 소괄호가 생략되면 매개변수 타입도 반드시 생략되어야 함

public class LambdaExpression {
    public static void main(String[] args) {

    }
}
