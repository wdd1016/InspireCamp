package grammar;

// 기본 생성자 ⇒ 생성자를 포함하지 않은 클래스에서 컴파일러가 자동으로 추가하는 생성자
//            (기본 생성자는 매개변수가 없고 생성자 본문이 비어 있음)

class ThisField {
    private int data = 100;

    // this를 생략하여도 컴파일러가 자동으로 this를 추가
    public void print() {
        System.out.println(data);    // this.data
    }

    // this 키워드 ⇒ 자신이 포함된 클래스의 객체를 가리키는 참조 변수
    // 매개변수의 이름과 필드의 이름이 동일한 경우
    // >> 명시적으로 this.를 사용
    public void setData(int data) {
        this.data = data;
    }
}

class ThisFunction {
    String name;
    int age;
    boolean isMarried;

    ThisFunction() {
        System.out.println("첫번째 생성자");
        this.name = "아무개";
        this.age = 0;
        this.isMarried = false;
    }

    // this() 메서드 ⇒ 자신이 속한 클래스 내부의 다른 생성자를 호출
    //              ⇒ 생성자 내부에서만 사용할 수 있고, 생성자의 첫 줄에 위치해야 함
    ThisFunction(int age) {
        // 생성자 내부에서 사용할 수 있고, 반드시 첫번째줄에 위치
        this();
        this.age = age;
        System.out.println("두번째 생성자");
    }

    ThisFunction(int age, boolean isMarried) {
        this(age);
        this.isMarried = isMarried;
        System.out.println("세번째 생성자");
    }

    void print() {
        System.out.println("name >>> " + this.name);
        System.out.println("age >>> " + this.age);
        System.out.println("isMarried >>> " + this.isMarried);
    }

    void doSomething() {
        // 메서드 내에서는 this() 메서드를 사용할 수 없음
        // this();
    }
}

public class This {
    public static void main(String[] args) {
        ThisField thisField = new ThisField();
        thisField.print();       // 100
        thisField.setData(200);
        thisField.print();		 // 200

        System.out.println();
        ThisFunction thisFunction1 = new ThisFunction();
        thisFunction1.print();
        System.out.println();
        ThisFunction thisFunction2 = new ThisFunction(100);
        thisFunction2.print();
        System.out.println();
        ThisFunction thisFunction3 = new ThisFunction(100, true);
        thisFunction3.print();
    }
}


