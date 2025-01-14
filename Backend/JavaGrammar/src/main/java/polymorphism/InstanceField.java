package polymorphism;

class InstanceParent {
    int m = 3;

    void print() {
        System.out.println("InstanceParent");
    }
}

class InstanceChild extends InstanceParent {
    int m = 4;

    @Override
    void print() {
        System.out.println("InstanceChild");
    }
}


public class InstanceField {
    public static void main(String[] args) {
        InstanceParent aa = new InstanceParent();
        InstanceChild bb = new InstanceChild();
        InstanceParent ab = new InstanceChild();

        aa.print();                // InstanceParent
        bb.print();                // InstanceChild

        // 자식의 함수 호출
        ab.print();                // InstanceChild

        System.out.println(aa.m);        // 3
        System.out.println(bb.m);        // 4

        // 부모의 변수 호출
        System.out.println(ab.m);        // 3
        System.out.println(((InstanceChild) ab).m);    // 4
    }
}
