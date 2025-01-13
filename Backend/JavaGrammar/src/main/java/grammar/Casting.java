package grammar;

public class Casting {

    class A {
        int m = 3;
        void abc() {
            System.out.println("A");
        }
    }

    class B extends A {
        int n = 4;
        void bcd() {
            System.out.println("B");
        }
    }

    class C extends B { }

    // 업캐스팅 테스트 메서드
    void testUpcasting() {
        System.out.println("=== 업캐스팅 ===");
        B b1 = new B();
        A a1 = b1; // A 타입으로 업캐스팅
        System.out.println("업캐스팅 성공: A a1 = (A) b1;");

        C c2 = new C();
        B b2 = c2; // B 타입으로 업캐스팅
        A a2 = c2; // A 타입으로 업캐스팅
        System.out.println("업캐스팅 성공: B b2 = (B) c2; A a2 = (A) c2;");
    }

    // 다운캐스팅 테스트 메서드
    void testDowncasting() {
        System.out.println("\n=== 다운캐스팅 ===");
        A a2 = new B(); // 부모 타입 변수로 자식 객체를 참조
        B b2 = (B) a2;  // 다운캐스팅 (성공)
        System.out.println("다운캐스팅 성공: B b2 = (B) a2;");

        A a1 = new A();
        // B b1 = (B) a1;  // 주석: 예외 발생, 컴파일러는 허용하지만 런타임에 ClassCastException
        System.out.println("다운캐스팅 실패: A a1을 B로 캐스팅 불가");
    }

    // 객체의 메서드와 필드 접근 테스트 메서드
    void testInstanceMethods() {
        System.out.println("\n=== 객체 메서드 및 필드 접근 ===");
        B b = new B();
        System.out.println("b.m: " + b.m);  // A의 필드
        System.out.println("b.n: " + b.n);  // B의 필드
        b.abc();  // A의 메서드
        b.bcd();  // B의 메서드

        A a = new B(); // B 객체를 A 타입으로 참조
        System.out.println("a.m: " + a.m);  // A의 필드
        a.abc();  // A의 메서드
        // System.out.println(a.n);  // 오류: A 타입에는 n이 정의되어 있지 않음
        // a.bcd();  // 오류: A 타입에는 bcd() 메서드가 없음
    }

    // instanceof 키워드 테스트 메서드
    void testInstanceOf() {
        System.out.println("\n=== instanceof 테스트 ===");

        A aa = new A();
        A ab = new B();

        System.out.println("aa instanceof A: " + (aa instanceof A)); // true
        System.out.println("aa instanceof B: " + (aa instanceof B)); // false
        System.out.println("ab instanceof A: " + (ab instanceof A)); // true
        System.out.println("ab instanceof B: " + (ab instanceof B)); // true

        if (ab instanceof B) {
            B b = (B) ab; // 안전한 다운캐스팅
            System.out.println("다운캐스팅 가능: ab -> B");
        }
    }

    public static void main(String[] args) {
        Casting casting = new Casting();
        casting.testUpcasting();
        casting.testDowncasting();
        casting.testInstanceMethods();
        casting.testInstanceOf();
    }
}
