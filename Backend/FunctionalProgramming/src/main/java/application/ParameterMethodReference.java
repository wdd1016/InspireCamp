package application;

@FunctionalInterface
interface InterfaceD {
    // 클래스 C의 print() 메서드를 이용해서 매개변수 i의 출력
    void printNumber(ClassD d, int i);
}

class ClassD {
    void print(int i) {
        System.out.println(i);
    }
}

public class ParameterMethodReference {
    public static void main(String[] args) {
        // 구현 클래스 정의 후 인스턴스를 생성해서 실행
        class ClassN implements InterfaceD {
            @Override
            public void printNumber(ClassD d, int i) {
                d.print(i);
            }
        }
        InterfaceD i1 = new ClassN();
        i1.printNumber(new ClassD(), 100);

        // 익명 이너 클래스를 이용해서 실행
        InterfaceD i2 = new InterfaceD() {
            @Override
            public void printNumber(ClassD d, int i) {
                d.print(i);
            }
        };
        i2.printNumber(new ClassD(), 100);

        // 람다식을 이용해서 실행
        InterfaceD i3 = (ClassD d, int i) -> d.print(i);
        i3.printNumber(new ClassD(), 100);

        // 메서드 참조를 이용해서 실행
        InterfaceD i4 = ClassD::print;
        i4.printNumber(new ClassD(), 100);
    }
}
