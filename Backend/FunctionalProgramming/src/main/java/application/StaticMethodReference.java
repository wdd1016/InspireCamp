package application;

@FunctionalInterface
interface InterfaceC {
    // 클래스 C의 smile() 메서드를 호출
    void printSmile();
}

class ClassC {
    static void smile() {
        System.out.println("^_^");
    }
}

public class StaticMethodReference {
    public static void main(String[] args) {
        // 구현 클래스 정의 후 인스턴스를 생성해서 실행
        class ClassN implements InterfaceC {
            @Override
            public void printSmile() {
                ClassC.smile();
            }
        }
        InterfaceC i1 = new ClassN();
        i1.printSmile();

        // 익명 이너 클래스를 이용해서 실행
        InterfaceC i2 = new InterfaceC() {
            @Override
            public void printSmile() {
                ClassC.smile();
            }
        };
        i2.printSmile();

        // 람다식을 이용해서 실행
        InterfaceC i3 = () -> ClassC.smile();
        i3.printSmile();

        // 메서드 참조를 이용해서 실행
        InterfaceC i4 = ClassC::smile;
        i4.printSmile();
    }
}
