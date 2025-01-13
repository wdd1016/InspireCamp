package polymorphism;

class Parent {
    void print() {
        System.out.println("Parent 클래스");
    }
}

class Child extends Parent {
    // 오버라이딩
    @Override
    void print() {
        System.out.println("Child 클래스");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Parent aa = new Parent();
        aa.print();        // Parent 클래스

        Child bb = new Child();
        bb.print();        // Child 클래스

        Parent ab = new Child();
        ab.print();        // Child 클래스
    }
}
