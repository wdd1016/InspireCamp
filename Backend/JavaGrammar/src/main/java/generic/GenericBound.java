package generic;

// 제네릭 메서드 내에는 기본적으로 Object 에서 물려받은 메서드만 사용이 가능

// 제네릭 타입 범위 제한(bound) : 제네릭 타입으로 올 수 있는 실제 타입의 종류를 제한
// ⇒ 메서드 내부에서 사용할 수 있는 메서드가 증가

// 제네릭 클래스의 타입 제한
// 접근지정자 class 클래스명 <제네릭타입 extends 클래스/인터페이스명> { ... }
class FruitBound {
    public void print() {
        System.out.println("과일");
    }
}

class AppleBound extends FruitBound {
}

class PencilBound {
}

class ClassGoods<T extends FruitBound> {
    private T t;

    public T get() {
        t.print();
        return this.t;
    }

    public void set(T t) {
        t.print(); // ⇐ 제한된 범위 내에서 사용할 수 있는 메서드를 사용하는 것이 가능
        this.t = t;
    }
}

// 제네릭 메서드의 타입 제한
// 접근지정자 <T extends 클래스/인터페이스명> T 메서드명(T t) { ... }
class GenericBoundedMethod {
    // public <T> void method(T t) {
    //     char c = t.charAt(0);       // Object 메서드만 사용 가능
    //     System.out.println(t);
    // }

    public <T extends String> void method(T t) {
        char c = t.charAt(0);       // Object 메서드와 String 메서드 사용이 가능
        System.out.println(t);
    }
}

// 메서드 매개변수일 때 제네릭 클래스의 타입 제한

// 리턴타입 메서드명(제네릭클래스명<제네릭타입명> 참조변수명) { ... }
// method(VariableGoods<AppleBound> v) 		⇒ 제네릭타입 = Apple 객체만 가능
// 리턴타입 메서드명(제네릭클래스명<?> 참조변수명) { ... }
// method(VariableGoods<?> v) 			⇒ 제네릭타입 = 모든 타입인 객체 가능
// 리턴타입 메서드명(제네릭클래스명<? extends 클래스/인터페이스명> 참조변수명) { ... }
// method(VariableGoods<? extends FruitBound> v) 	⇒ 제네릭타입 = Fruit 또는 Fruit 의 자식 클래스인 객체만 가능
// 리턴타입 메서드명(제네릭클래스명<? super 클래스/인터페이스명> 참조변수명) { ... }
// method(VariableGoods<? super FruitBound> v) 	⇒ 제네릭타입 = Fruit 또는 Fruit 의 부모 클래스인 객체만 가능
class A {
}

class B extends A {
}

class C extends B {
}

class D extends C {
}

class VariableGoods<T> {
    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t) {
        this.t = t;
    }
}

class GenericVariableBoundedMethod {
    void method1(VariableGoods<A> g) {
    } // case1

    void method2(VariableGoods<?> g) {
    } // case2

    void method3(VariableGoods<? extends B> g) {
    } // case3

    void method4(VariableGoods<? super B> g) {
    } // case4
}


public class GenericBound {
    public static void main(String[] args) {
        ClassGoods<AppleBound> goods1 = new ClassGoods<>();
        goods1.set(new AppleBound());

        // Bound mismatch: The type Pencil is not a valid substitute for the bounded parameter <T extends FruitBound> of the type ClassGoods<T>
        // ClassGoods<PencilBound> goods2 = new ClassGoods<>(); ⇐ 제한된 범위 밖의 타입이 사용되는 것을 방지
        // goods2.set(new PencilBound());

        GenericBoundedMethod gm1 = new GenericBoundedMethod();
        gm1.<String>method("문자열");

        // Bound mismatch: The generic method method(T) of type GenericBoundedMethod is not applicable for the arguments (Integer).
        // The inferred type Integer is not a valid substitute for the bounded parameter <T extends String>
        // gm1.<Integer>method(123);

        // 메서드 매개변수일 때 제네릭 클래스의 타입 제한
        GenericVariableBoundedMethod gm2 = new GenericVariableBoundedMethod();

        // case1 (VariableGoods<A> g)
        gm2.method1(new VariableGoods<A>());
        // gm2.method1(new VariableGoods<B>());
        // gm2.method1(new VariableGoods<C>());
        // gm2.method1(new VariableGoods<D>());
        // gm2.method1(new VariableGoods<String>());

        // case2 (VariableGoods<?> g)
        gm2.method2(new VariableGoods<A>());
        gm2.method2(new VariableGoods<B>());
        gm2.method2(new VariableGoods<C>());
        gm2.method2(new VariableGoods<D>());
        gm2.method2(new VariableGoods<String>());

        // case3 (VariableGoods<? extends B> g)
        // gm2.method3(new VariableGoods<A>());
        gm2.method3(new VariableGoods<B>());
        gm2.method3(new VariableGoods<C>());
        gm2.method3(new VariableGoods<D>());
        // gm2.method3(new VariableGoods<String>());

        // case4 (VariableGoods<? super B> g)
        gm2.method4(new VariableGoods<A>());
        gm2.method4(new VariableGoods<B>());
        // gm2.method4(new VariableGoods<C>());
        // gm2.method4(new VariableGoods<D>());
        // gm2.method4(new VariableGoods<String>());
    }
}
