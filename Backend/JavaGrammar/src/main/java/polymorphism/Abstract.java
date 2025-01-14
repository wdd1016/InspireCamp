package polymorphism;

// 추상 메서드 : abstract 리턴타입 메서드이름(매개변수);
// 추상 클래스
// 하나 이상의 추상 메서드를 포함하고 있는 클래스
// 객체를 직접 생성할 수 없음 ⇒ A a = new A(); 와 같이 생성자를 호출할 수 없음 ⇒ (추상 메서드를 구현한) 자식 클래스를 이용해서 생성
//                                                                                     추상 메서드를 오버라이딩 = 구현한다(implements)
// 추상 메서드를 포함하지 않는(=일반 메서드로만 구성된) 클래스도 추상 클래스가 될 수 있음

// 추상 메서드를 사용하지 않는 경우
class WrongDog extends Animal {
    // Method does not override method from its superclass
    // @Override
    void CRY() { // ⇐ 잘못된 구현이 발생할 수 있음 (새로운 메서드를 정의)
        System.out.println("멍멍");
    }
}

// 추상 클래스 타입의 객체를 생성하는 방법
// 1. 상속해서 객체를 생성
abstract class AbstractAnimal {
    abstract void cry(); // ⇐ 추상 메서드를 포함하면 추상 클래스가 되어야 함
}

class RealCat extends AbstractAnimal {
    void cry() {
        System.out.println("야옹");
    }
}

// The type Dog must implement the inherited abstract method AbstractAnimal.cry()
// class RealDog extends AbstractAnimal { // ⇐ 추상 클래스를 상속 받으면 추상 메서드를 구현(오버라이딩)하거나 추상 클래스가 되어야 함
//    void CRY() { System.out.println("멍멍"); }


// 추상 클래스 타입의 객체를 생성하는 방법
// 2.익명 이너 클래스를 사용 ⇒ 한 번만 만들어서 사용할 경우
abstract class AbstractInnerAnimal {
    abstract void cry();
}

public class Abstract {
    public static void main(String[] args) {
        AbstractAnimal animal = new RealCat();
        RealCat cat = new RealCat();

        animal.cry();       // 야옹
        cat.cry();          // 야옹

        AbstractInnerAnimal innerAnimal = new AbstractInnerAnimal() {
            void cry() {
                System.out.println("야용");
            }
        };
        innerAnimal.cry();  // 야옹
    }
}
