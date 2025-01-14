package polymorphism;

// 클래스가 인터페이스를 상속할 때
interface InterfaceF {
    void abc(); // public abstract가 생략되어 있음 ⇒ 자식 클래스의 메서드는 public으로 선언
}

// 1. 자식 클래스는 반드시 추상 메서드를 구현해야 함
// class 'ImplD' must either be declared abstract or implement abstract method 'abc()' in 'InterfaceF'
// class ImplD implements InterfaceF {}

// 인터페이스의 추상 메서드를 구현하지 않으면 추상 클래스로 정의해야 함
abstract class AbstractG implements InterfaceF {
}

// 2. 자식 클래스의 구현 메서드는 public만 가능
abstract class AbstractH implements InterfaceF {
    // Cannot reduce the visibility of the inherited method from InterfaceF
    // void abc() { System.out.println("Hello"); }
}

public class InterfaceChildClass {
    public static void main(String[] args) {

    }
}
