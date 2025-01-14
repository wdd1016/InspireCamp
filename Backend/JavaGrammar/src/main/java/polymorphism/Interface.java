package polymorphism;

// 인터페이스
// 모든 필드가 public static final 로 정의,
// static 메서드와 default 메서드를 제외한 모든 메서드는 public abstract 로 정의된 객체지향 프로그래밍 요소

// class 대신 interface 키워드를 사용해서 선언
// 필드와 메서드에 제어자(modifier)를 생략하면 컴파일러가 자동으로 제어자를 삽입

interface InterfaceAlpha {
    int a = 3;  // public static final int a = 3;

    void abc(); // public abstract void abc();
}

// 인터페이스를 상속할 때는 implements 키워드를 사용하고, 다중 상속이 가능
interface InterfaceA {
}

interface InterfaceB {
}

// 인터페이스는 다중 상속이 가능
class ImplA implements InterfaceA, InterfaceB {
}

class ImplB implements InterfaceB {
}

// 클래스와 인터페이스를 동시에 상속
class ImplC extends ImplB implements InterfaceA {
}

// 인터페이스는 인터페이스만 상속 받을 수 있음
interface InterfaceC extends InterfaceA {
}

// The type ImplA cannot be a superinterface of InterfaceD; a superinterface must be an interface.
// interface InterfaceD extends ImplA {}

// Syntax error on token "implements", extends expected
// interface InterfaceE implements InterfaceA {}

public class Interface {
    public static void main(String[] args) {
        
    }
}
