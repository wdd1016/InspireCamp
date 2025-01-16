package application;

// 이미 구현되어 있는 인스턴스 메서드를 참조 ⇒ 객체참조변수::인스턴스메서드명
// 반드시 객체를 먼저 생성해야 함

interface InterfaceA {
    void iii(); // C 클래스의 aaa() 메서드를 호출
}

class ClassA {
    void aaa() {
        System.out.println("aaa()");
    }
}

public class InstanceMethodReference {
    public static void main(String[] args) {
        // 익명 이너클래스
        InterfaceA instance1 = new InterfaceA() {
            @Override
            public void iii() {
                ClassA a = new ClassA();
                a.aaa();
            }
        };
        instance1.iii();

        // 람다식
        InterfaceA instance2 = () -> {
            ClassA b = new ClassA();
            b.aaa();
        };
        instance2.iii();

        // 메서드 참조로 변경
        ClassA c = new ClassA();
        InterfaceA instance3 = c::aaa;
        instance3.iii();
    }
}
