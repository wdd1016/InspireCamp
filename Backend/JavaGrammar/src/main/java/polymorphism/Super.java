package polymorphism;

// cf) this 키워드, this() 메서드
// this ⇒ 자신의 객체
// this() ⇒  자신의 생성자
//
// super ⇒ 부모 객체 ⇒ 부모 필드 또는 메서드를 호출하기 위해 사용
// super() ⇒ 부모의 생성자

class SuperParent {
    void print() {
        System.out.println("SuperParent");
    }

    void doSomething() {
        System.out.println("메모리 할당");
        System.out.println("UI를 설정");
        System.out.println("변수를 초기화");
        System.out.println("기타 등등 많은 작업을 수행");
    }
}

class SuperChild extends SuperParent {
    void print() {
        System.out.println("SuperChild");
    }

    void parentPrint() {
        super.print();
    }
}

class SuperWrongChild extends SuperParent {
    @Override
    void doSomething() {
        System.out.println("메모리 할당");
        System.out.println("UI를 설정");
        System.out.println("변수를 초기화");
        System.out.println("기타 등등 많은 작업을 수행");

        System.out.println("자식 클래스에서 필요한 기능을 수행");
    }
}

class SuperRightChild extends SuperParent {
    @Override
    void doSomething() {
        super.doSomething();
        System.out.println("자식 클래스에서 필요한 기능을 수행");
    }
}

// super() 메서드 ⇒ 생성자 내부에서만 사용이 가능하고, 반드시 첫 줄에 위치해야 함
// ⇒ this(), super()는 함께 사용할 수 없음

// 모든 생성자는 첫 줄에 반드시 this() 또는 super()가 있어야 함
// ⇒ 아무것도 사용하지 않으면 컴파일러가 자동으로 super()를 삽입
class SuperMethodParent {
    SuperMethodParent(int a) {
        System.out.println("SuperMethodParent");
    }
}

// Implicit super constructor SuperMethodParent() is undefined for default constructor.
// Must define an explicit constructor
class SuperMethodChild extends SuperMethodParent {
    /*
     * 컴파일러가 아래와 같은 기본 생성자를 자동으로 만들어 줌
     * super()에 대응하는 생성자 SuperMethodParent 클래스에 없기 때문에 발생
     * SuperMethodChild() {
        super();
     }
     */

    SuperMethodChild() {
        super(1);
    }
}


public class Super {
    public static void main(String[] args) {
        SuperParent aa = new SuperParent();
        SuperChild bb = new SuperChild();
        SuperParent ab = new SuperChild();

        aa.print();    // SuperParent
        bb.print();    // SuperChild
        ab.print();    // SuperChild

        bb.parentPrint();                   // SuperParent
        ((SuperChild) ab).parentPrint();    // SuperParent

        SuperMethodParent cc = new SuperMethodParent(1);
        SuperMethodChild dd = new SuperMethodChild();
    }
}
