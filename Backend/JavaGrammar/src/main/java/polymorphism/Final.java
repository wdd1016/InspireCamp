package polymorphism;

// final 제어자
// 필드, 지역 변수, 메서드, 클래스 앞에 올 수 있음

// final 변수 ⇒ final 필드, final 지역변수
class FinalVariable {
    int a = 3;
    final int b = 5;

    // 인스턴스 필드는 자동으로 초기화되나
    int c;
    // final 변수는 선언과 동시에 초기화하던지, 아니면 생성자에서 반드시 초기화해야 함
    final int d;

    int e = 3;
    final int f = 5;

    FinalVariable() {
        this.d = 5;

        this.e = 7;
        // 한 번 대입된 값을 수정할 수 없음
        // this.f = 10;
    }
}

class FinalMethodParent {
    void func() {
    }

    final void func2() {
    }
}

// final 메서드 ⇒ 자식 클래스에서 해당 메서드를 오버라이딩할 수 없음
class FinalMethodChild extends FinalMethodParent {
    void func() {
    }

    // 'func2()' cannot override 'func2()' in 'polymorphism. FinalMethodParent'; overridden method is final
    // void func2() {}
}

// final 클래스 ⇒ 상속할 수 없는 클래스
// ex) String 클래스 : 불변성을 위해서
final class FinalClassParent {
}

// Cannot inherit from final 'polymorphism. FinalClassParent'
// class FinalClassChild extends FinalClassParent {}

public class Final {
    public static void main(String[] args) {
    }
}
