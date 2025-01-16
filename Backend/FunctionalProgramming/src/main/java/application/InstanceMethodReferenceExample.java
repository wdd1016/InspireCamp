package application;

@FunctionalInterface
interface InterfaceB {
    // 매개변수로 전달된 i 값을 출력
    void printNumber(int i);
}

public class InstanceMethodReferenceExample {
    public static void main(String[] args) {
        // 구현 클래스 정의 후 인스턴스를 생성해서 실행
        class ClassB implements InterfaceB {
            @Override
            public void printNumber(int i) {
                System.out.println(i);
            }
        }
        InterfaceB interface1 = new ClassB();
        interface1.printNumber(100);

        // 익명 이너 클래스를 이용해서 실행
        InterfaceB interface2 = new InterfaceB() {
            @Override
            public void printNumber(int i) {
                System.out.println(i);
            }
        };
        interface2.printNumber(100);

        // 람다식을 이용해서 실행
        InterfaceB interface3 = (i) -> System.out.println(i);
        interface3.printNumber(100);

        // 메서드 참조를 이용해서 실행
        InterfaceB interface4 = System.out::println;
        interface4.printNumber(100);
    }
}
