package polymorphism;

// default 메서드 ⇒ 하위 호환성을 보장하기 위해서 추가
//  예) List 인터페이스에 replaceAll 메서드
//  default void replaceAll(UnaryOperator<E> operator) {
//      Objects.requireNonNull(operator);
//      final ListIterator<E> li = this.listIterator();
//      while (li.hasNext()) {
//          li.set(operator.apply(li.next()));
//      }
//  }

interface InterfaceK {
    void abc();

    void bcd();

    // void xyz(); // ⇐ 새로운 메서드가 추가되면
}

// 인터페이스를 상속한 클래스는 추상 메서드를 구현해야 함
// Class 'ImplK' must either be declared abstract or implement abstract method 'xyz()' in 'InterfaceK'
class ImplK implements InterfaceK {
    @Override
    public void abc() {
    }

    @Override
    public void bcd() {
    }
}

// 새롭게 추가한 메서드에 default 키워드를 추가하면 해당 인터페이스를 상속한 클래스에서 해당 메서드를 구현하지 않아도되도록 하는 문법
interface InterfaceL {
    void abc();

    void bcd();

    default void xyz() {

    }

    ;
}

public class InterfaceDefaultMethod {
    public static void main(String[] args) {
        InterfaceK aa = new ImplK();
        aa.abc();
        aa.bcd();
    }
}