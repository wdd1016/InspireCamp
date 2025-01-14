package polymorphism;

class StaticParent {
    static int m = 3;

    static void print() {
        System.out.println("StaticParent");
    }
}

class StaticChild extends StaticParent {
    static int m = 4;

    static void print() {
        System.out.println("StaticChild");
    }
}

// Static은 오버라이딩 X
public class StaticFieldMethod {
    public static void main(String[] args) {
        // 클래스 이름을 이용해서 static 필드에 접근
        System.out.println(StaticParent.m);        // 3
        System.out.println(StaticChild.m);        // 4

        StaticParent aa = new StaticParent();
        StaticChild bb = new StaticChild();
        StaticParent ab = new StaticChild();

        // 인스턴스 변수를 이용해서 static 필드에 접근 => warning 발생
        // The static field StaticParent.m should be accessed in a static way
        System.out.println(aa.m);        // 3
        System.out.println(bb.m);        // 4
        System.out.println(ab.m);        // 3
        System.out.println(((StaticChild) ab).m);    // 4

        // 클래스 이름을 이용해서 static 메서드를 실행
        StaticParent.print();    // StaticParent
        StaticChild.print();    // StaticChild

        // 인스턴스 변수를 이용해서 static 메서드를 실행 => warning 발생
        // The static method print() from the type StaticParent should be accessed in a static way
        StaticParent aa2 = new StaticParent();
        StaticChild bb2 = new StaticChild();
        StaticParent ab2 = new StaticChild();

        aa2.print();    // StaticParent
        bb2.print();    // StaticChild
        ab2.print();    // StaticParent
    }

}
