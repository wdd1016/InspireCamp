package application;

// 익명 이너 클래스 내부 구현 메서드의 약식 표현

// 매개변수 X, 반환값 X
@FunctionalInterface
interface XX {
    void method();  // public abstract void method();
}

public class AnonymousClass {
    public static void main(String[] args) {
        // 구현 클래스를 정의하고, 해당 클래스의 인스턴스를 이용해서 메서드를 호출
        class XXClass implements XX {
            @Override
            public void method() {
                System.out.println("XX1");
            }
        }
        XX xx1 = new XXClass();
        xx1.method();

        // 익명 이너 클래스를 정의해서 메서드를 호출
        XX xx2 = new XX() {
            @Override
            public void method() {
                System.out.println("XX2");
            }
        };
        xx2.method();

        // 람다 표현식
        XX xx3 = () -> System.out.println("XX3");
        xx3.method();
    }
}



