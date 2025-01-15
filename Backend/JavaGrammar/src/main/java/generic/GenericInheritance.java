package generic;

// 제네릭 클래스의 상속 ⇒ 부모 클래스가 제네릭 클래스일 때, 이를 상속한 자식 클래스도 제네릭 클래스가 됨
// ⇒ 제네릭 타입 변수를 자식 클래스가 그대로 물려받게 되고, 또한 자식 클래스는 제네릭 타입 변수를 추가해 정의할 수 있음
// ⇒ 자식 클래스의 제네릭 타입 변수의 개수는 항상 부모 보다 같거나 많게 됨

// 부모 클래스와 제네릭 타입 변수의 개수가 동일한 경우
// class Parent<K, V> { ... }
// class Child<K, V> extends Parent<K, V> { ... }

// 부모 클래스와 제네릭 타입 변수의 개수가 많은 경우
// class Parent<K> { ... }
// class Child<K, V> extends Parent<K> { ... }

class Parent<T> {
    private T t;

    public T getT() {
        return this.t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class Child1<T> extends Parent<T> {
}

class Child2<T, V> extends Parent<T> {
    private V v;

    public V getV() {
        return this.v;
    }

    public void setV(V v) {
        this.v = v;
    }
}

// 제네릭 메서드도 상속이 가능
class MethodParent {
    <T extends Number> void print(T t) {
        System.out.println(t);
    }
}

class MethodChild extends MethodParent {
}


public class GenericInheritance {
    public static void main(String[] args) {
        // 부모 제네릭 클래스
        Parent<String> p1 = new Parent<>();
        p1.setT("부모 제네릭 클래스");
        System.out.println(p1.getT());

        // 자식 클래스 1
        Child1<String> c1 = new Child1<>();
        c1.setT("자식 클래스 1");
        System.out.println(c1.getT());

        // 자식 클래스 2
        Child2<String, Integer> c2 = new Child2<>();
        c2.setT("자식 클래스 2");
        c2.setV(1234);
        System.out.println(c2.getT());
        System.out.println(c2.getV());

        // 제네릭 메서드 상속
        MethodParent p2 = new MethodParent();
        p2.<Integer>print(10);
        p2.print(100);
        MethodChild c3 = new MethodChild();
        c3.<Double>print(5.8);
        c3.print(5.8);

    }
}
