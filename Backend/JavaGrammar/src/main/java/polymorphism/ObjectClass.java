package polymorphism;

// 자바의 모든 클래스는 Object 클래스를 상속
// ⇒ 아무런 클래스를 상속받지 않으면 컴파일러가 자동으로 extends Object 코드를 삽입해서 Object 클래스를 상속하도록 함

// Object 클래스의 메서드 ⇒ https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html

class ClassA {
    String name;

    ClassA(String name) {
        this.name = name;
    }
}

// public boolean equals(Object obj) : 스택 메모리의 값(주소)를 비교
// == (등가 비교 연산자)와 동일한 결과, 실제 내용을 비교하려면 오버라이드해서 사용해야 함
class ClassB {
    String name;

    ClassB(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ClassB && this.name == ((ClassB) obj).name) {
            return true;
        }
        return false;
    }
}

// toString() ⇒ 객체 정보(패키지이름.클래스이름@해시코드)를 문자열로 리턴하는 메서드
// ⇒ 일반적으로 자식 클래스에서 toString() 메서드를 오버라이딩해서 사용
class ClassC {
    String name;

    ClassC(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "이름은 " + this.name + "입니다.";
    }
}

// 해쉬(Hash, Message Digest) ⇒ 입력을 이용해서 고정 길이의 고유한 값을 추출하는 함수
// 단방향성  D -- o --> H(D) -- x --> D 	⇒ 인증 정보를 저장, 인증 처리할 때 사용
// 유일성    D <> D' → H(D) <> H(D') 		⇒ 무결성 보장을 할 때 사용

public class ObjectClass {
    public static void main(String[] args) {
        String s1 = new String("안녕");
        String s2 = new String("안녕");

        System.out.println(s1 == s2);       // false
        System.out.println(s1.equals(s2));  // true
        System.out.println();


        ClassA a1 = new ClassA("안녕");
        ClassA a2 = new ClassA("안녕");
        ClassB b1 = new ClassB("안녕");
        ClassB b2 = new ClassB("안녕");
        ClassC c1 = new ClassC("안녕");

        System.out.println(a1 == a2);       // false
        System.out.println(a1.equals(a2));  // false
        System.out.println(b1 == b2);       // false
        System.out.println(b1.equals(b2));  // true
        System.out.println();

        System.out.println(a1);             // polymorphism.ClassA@cac736f
        System.out.println(c1);             // 이름은 안녕입니다.
        System.out.println();
    }
}
