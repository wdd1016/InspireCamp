package polymorphism;

// 정적 메서드(static method)
// 클래스 내부의 정적 메서드와 동일
// 인터페이스명.정적메서드명() 방식으로 호출해서 사용

interface InterfaceM {
    void abc();

    void bcd();

    default void xyz() {

    }

    static void hello() {
        System.out.println("Hello");
    }
}

class ImplM implements InterfaceM {
    @Override
    public void abc() {
    }

    @Override
    public void bcd() {
    }
}

public class InterfaceStaticMethod {
    public static void main(String[] args) {
        InterfaceM aa = new ImplM();
        aa.abc();
        aa.bcd();

        // 기존 코드(ImplM 클래스)를 수정하지 않고 새롭게 추가된 인터페이스의 기능 사용
        InterfaceM.hello();
    }
}
