package generic;

// 자바 제네릭
// 컴파일 타임에 타입을 지정해 타입 안정성을 보장하고, 코드 재사용성을 높이는 기능
// 클래스, 인터페이스, 메서드에 사용이 가능
// 주로 타입을 명시하지 않고도 다양한 데이터 타입을 처리하는 데 사용

// 기존 -> 새로운 상품이 추가될 때 마다 새로운 관리 클래스(ManageOOO)를 만들어야 하는 문제가 발생
class Apple {
}

class Pencil {
}

class ManageApple {
    private Apple apple = new Apple();

    public Apple get() {
        return this.apple;
    }

    public void set(Apple apple) {
        this.apple = apple;
    }
}

class ManagePencil {
    private Pencil pencil = new Pencil();

    public Pencil get() {
        return this.pencil;
    }

    public void set(Pencil pencil) {
        this.pencil = pencil;
    }
}

// 해결 방법 1. 필드를 모든 자바 클래스의 최상위 클래스인 Object 타입으로 선언
class ObjectManage {
    private Object object = new Object();

    public Object get() {
        return this.object;
    }

    public void set(Object object) {
        this.object = object;
    }
}

// 해결 방법 2. 제네릭 클래스
class GenericManage<T> {
    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t) {
        this.t = t;
    }
}

// 제네릭 클래스와 제네릭 인터페이스를 정의
// 접근지정자 class 클래스이름 <제네릭타입변수>  {
//     제네릭타입변수를 사용하는 코드
// }
// 접근지정자 class 클래스이름 <제네릭타입변수, 제네릭타입변수>  {
//     제네릭타입변수를 사용하는 코드
// }
// 접근지정자 interface 인터페이스이름 <제네릭타입변수>  {
//     제네릭타입변수를 사용하는 코드
// }
// 접근지정자 interface 인터페이스이름 <제네릭타입변수, 제네릭타입변수>  {
//     제네릭타입변수를 사용하는 코드
// }

// 제네릭 타입 변수명은 사용자가 임의로 지정할 수 있지만, 관례적으로 아래와 같이 사용
// T		type
// K		key
// V		value
// N		number
// E		element

// 제네릭 클래스의 객체 생성 ⇒ 객체를 생성할 때 제네릭 타입 변수에 실제 타입을 대입
// 클래스명<실제제네릭타입> 참조변수명 = new 클래스명<실제제네릭타입>();
// or 클래스명<실제제네릭타입> 참조변수명 = new 클래스명<>();

// 제네릭 클래스의 객체를 생성할 때 <실제 제네릭 타입>을 생략하면, Object가 대입

class GenericClassA<T> {
    T t;
    // ....
}

public class Generic {
    public static void main(String[] args) {
        // 기존
        ManageApple apple1 = new ManageApple();
        apple1.set(new Apple());
        Apple newApple1 = apple1.get();
        ManagePencil pencil1 = new ManagePencil();
        pencil1.set(new Pencil());
        Pencil newPencil = pencil1.get();

        // 해결 방법 1
        ObjectManage apple2 = new ObjectManage();
        apple2.set(new Apple());
        Apple newApple2 = (Apple) apple2.get();
        ObjectManage pencil2 = new ObjectManage();
        pencil2.set(new Pencil());
        Pencil newPencil2 = (Pencil) pencil2.get();
        // 데이터를 저장(set())할 때는 아무런 문제가 없으나,
        // 저장된 데이터를 가져올 때(get())는 저장된 형태로 캐스팅을 해야 함
        ObjectManage goods1 = new ObjectManage();
        // java.lang.ClassCastException : class Apple cannot be cast to class Pencil
        // goods1.set(new Apple());
        // Pencil pen = (Pencil) goods1.get();
        // 약한 타입 체크를 하기 때문에 컴파일 시점에서 캐스팅 오류가 발생하는지 알 수 없음
        // ⇒ 실행 시점에 실제 인스턴스 타입에 따라서 오류가 발생
        // ⇒ 잘못된 캐스트으로 발생할 수 있는 문제점을 사전에 예방하려면, 강한 타입 체크가 될 수 있도록 코드를 작성
        // ⇒ 제네릭 클래스, 제네릭 인터페이스 문법

        // 해결 방법 2
        GenericManage<Apple> goods2 = new GenericManage<>();
        goods2.set(new Apple());
        // Cannot cast from Apple to Pencil ⇐ 강한 타입 체크가 되기 때문에 컴파일 시점에 캐스팅 오류를 발견할 수 있음
        // Pencil pen = (Pencil)goods2.get();

        GenericClassA a = new GenericClassA();
        // ⇒ GenericClassA<Object> a = new GenericClassA<Object>();
    }
}
