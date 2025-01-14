package polymorphism;

// 인터페이스 타입의 객체를 생성하는 방법
// 1. 인터페이스를 일반 클래스로 상속해 객체 생성
interface InterfaceI {
    int a = 3;        // public static final

    void abc();        // public abstract
}

// 여러 개의 객체를 생성해서 사용할 경우
class ImplI implements InterfaceI {
    public void abc() {
        System.out.println("Hello");
    }
}

// 인터페이스 타입의 객체를 생성하는 방법
// 2. 익명 이너 클래스를 사용 - 객체 하나만 생성할 때 사용
interface InterfaceJ {
    int a = 3;        // public static final

    void abc();        // public abstract
}

public class InterfaceObject {
    public static void main(String[] args) {
        // InterfaceI a = new InterfaceI();	// (X)
        InterfaceI b = new ImplI();
        ImplI c = new ImplI();

        InterfaceJ d = new InterfaceJ() {
            @Override
            public void abc() {
                System.out.println("Hello");
            }
        };
    }

}
