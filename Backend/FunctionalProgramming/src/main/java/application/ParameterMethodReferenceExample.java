package application;

interface InterfaceE {
    // 매개변수로 전달된 s의 길이를 반환
    int stringLength(String s);
}

public class ParameterMethodReferenceExample {
    public static void main(String[] args) {
        // 메서드 참조를 이용해서 실행
        InterfaceE i4 = String::length;
        System.out.println(i4.stringLength("hello, lambda"));   // 13

        // 람다식을 이용해서 실행
        InterfaceE i3 = s -> s.length();
        System.out.println(i3.stringLength("hello, lambda"));

        // 익명 이너 클래스를 이용해서 실행
        InterfaceE i2 = new InterfaceE() {
            @Override
            public int stringLength(String s) {
                return s.length();
            }
        };
        System.out.println(i2.stringLength("hello, lambda"));

        // 구현 클래스 정의 후 인스턴스를 생성해서 실행
        class ClassN implements InterfaceE {
            @Override
            public int stringLength(String s) {
                return s.length();
            }
        }
        InterfaceE i1 = new ClassN();
        System.out.println(i1.stringLength("hello, lambda"));
    }
}