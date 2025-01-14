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

class Animal {
    void cry() {
        System.out.println("운다.");
    }
}

class Bird extends Animal {
    @Override
    void cry() {
        System.out.println("짹짹");
    }
}

class Cat extends Animal {
    @Override
    void cry() {
        System.out.println("야옹");
    }
}

class Dog extends Animal {
    @Override
    void cry() {
        System.out.println("멍멍");
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

        Animal bird = new Bird();
        Animal cat = new Cat();
        Animal dog = new Dog();

        bird.cry();
        cat.cry();
        dog.cry();

        Animal[] animals = new Animal[]{new Bird(), new Cat(), new Dog()};
        for (Animal a : animals) {
            a.cry();
        }
    }
}

// 메서드 오버라이딩 시 접근 지정자는 부모 보다 범위가 같거나 넓은 접근 지정자를 사용
// 부모 클래스 메서드의 접근 지정자		메서드 오버라이딩 시 사용할 수 있는 접근 지정자
// public 						    public
// protected					    public, protected
// default						    public, protected, default
//
// private						    public, protected, default, private
// ~~~~~~~                  	    ~~~~~~~~~~~~~~~~~~~~~~~~~~  ~~~~~~~
// |                                자식 클래스에서 새로운 메서드를 정의
// |
// +-- 해당 클래스 내부에서만 사용 가능하고 상속되지 않으므로, 오버라이딩 대상이 되지 않음
//
