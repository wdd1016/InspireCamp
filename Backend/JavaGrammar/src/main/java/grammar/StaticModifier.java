package grammar;

class StaticInstanceVariable {
    int m = 3;
    static int n = 5;
}

class StaticInstanceMethod {
    int a = 3;
    static int b = 5;

    void abc() { // 객체를 생성한 후에 사용 가능
        System.out.println("인스턴스 메서드");
    }

    static void bcd() { // 객체를 생성하지 않고 사용이 가능
        System.out.println("정적 메서드");

        // 정적 메서드 내에서는 정적 필드 또는 정적 메서드만 사용이 가능
        // this 키워드를 사용할 수 없음
        System.out.println(b);
        // System.out.println(a); // impossible
    }
}

public class StaticModifier {

    // static main() 메서드
    public static void main(String[] args) {
        StaticInstanceVariable c = new StaticInstanceVariable();

        System.out.println("Static variable & Member variable");
        System.out.println(c.m);
        // System.out.println(c.n); // impossible
        System.out.println();

        StaticInstanceVariable a1 = new StaticInstanceVariable();
        StaticInstanceVariable a2 = new StaticInstanceVariable();

        a1.m = 5;
        a2.m = 6;
        System.out.println(a1.m); // 5
        System.out.println(a2.m); // 6

        a1.n = 7;
        a2.n = 8;
        System.out.println(a1.n); // 8
        System.out.println(a2.n); // 8

        StaticInstanceVariable.n = 9;
        System.out.println(a1.n); // 9
        System.out.println(a2.n); // 9
        System.out.println(StaticInstanceVariable.n);  // 9

        System.out.println();
        System.out.println("Static method & Instance method");

        // StaticInstanceMethod.abc(); // impossible
        StaticInstanceMethod.bcd();
        System.out.println();

        StaticInstanceMethod d = new StaticInstanceMethod();
        d.abc();
        d.bcd();
    }
}
