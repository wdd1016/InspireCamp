package grammar;

class Fruit { }
class Apple extends Fruit { }
class Grape extends Fruit { }
class Kiwi extends Fruit { }

class A {}
class B extends A { }
class C extends B { }
class D extends B { }

public class Inheritance {
    public static void main(String[] args) {
        Apple[] apples = { new Apple(), new Apple() };
        Grape[] grapes = { new Grape(), new Grape() };
        Kiwi[] kiwies = { new Kiwi(), new Kiwi() };
        Fruit[] fruits = { new Apple(), new Grape(), new Kiwi() };

        {
            // 다형적 표현이 올바르게 사용된 경우
            // 부모 변수 = 자식 인스턴스
            A a = new A();
            B b = new B();
            C c = new C();
            D d = new D();

            A a1 = new B();
            A a2 = new C();
            A a3 = new D();

            B b1 = new C();
            B b2 = new D();
        }

        {
            // 잘못된 사용 예
            // B b1 = new A();

            // C c1 = new A();
            // C c2 = new B();

            // D d1 = new A();
            // D d2 = new B();
            // D d3 = new C();
        }
    }
}
