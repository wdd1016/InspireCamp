package basic;

// 함수형 인터페이스(functional interface)
// 하나의 추상 메서드만 가지는 인터페이스
// @FunctionalInterface 어노테이션으로 함수형 인터페이스임을 명시할 수 있음 → 컴파일러가 두 개 이상의 추상 메서드를 선언하고 있으면 오류를 반환
// Runnable, Callable, Consumer<T>, Supplier<T>, Function<T, R> 등

// Invalid '@FunctionalInterface' annotation; InterfaceA is not a functional interface
// @FunctionalInterface
interface InterfaceA {
    void method();
    void otherMethod();
}

@FunctionalInterface
interface InterfaceB {
    void method();
}

// 함수형 인터페이스에 정의된 메서드를 호출하는 방법

// 객체 지향 프로그래밍 문법
// CASE1. 인터페이스의 구현 클래스를 만든 후 해당 클래스의 생성자를 이용해서 객체를 생성하고 객체의 참조 변수를 이용해서 메서드를 호출
class ClassC implements InterfaceB {
    @Override
    public void method() {
        System.out.println("CASE1: Class implementation");
    }
}
// CASE2. 익명 이너 클래스를 사용해 객체를 생성하고, 이 객체를 이용해서 메서드를 호출

// 함수형 프로그래밍 문법
// CASE3. 람다식을 활용 ⇒ 익명 이너 클래스의 메서드 정의 부분만 가져와 메서드를 정의하고 호출

public class FunctionalInterfaceProgramming {
    public static void main(String[] args) {
        // CASE1: 구현 클래스 작성 및 인스턴스 생성 방식
        InterfaceB case1 = new ClassC();
        case1.method();

        // CASE2: 익명 이너 클래스 방식
        InterfaceB case2 = new InterfaceB() {
            @Override
            public void method() {
                System.out.println("CASE2: Anonymous inner class");
            }
        };
        case2.method();

        // CASE3: 람다식을 사용한 함수형 프로그래밍 방식
        InterfaceB case3 = () -> System.out.println("CASE3: Lambda expression");
        case3.method();
    }
}
