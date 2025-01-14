package grammar;

// 예외 전가(throws) ⇒ 호출한 메서드가 예외를 처리하도록 전달
// 리턴타입 메서드이름(매개변수) throws 예외클래스명 {
//      예외 발생 코드
// }

// 전가된 예외는 최상위 메서드인 main() 메서드까지 올라가고
// main() 메서드에서도 예외를 전가하면 main() 메서드를 실행한 JVM이 직접 예외를 처리

import java.io.IOException;

class SimpleA {
    void methodA1() throws IOException, ArithmeticException {
        System.out.println("methodA");
        methodB();
    }

    void methodA2() {
        System.out.println("methodA");
        try {
            methodB();
        } catch (ArithmeticException | IOException e) {
            e.printStackTrace();
        }
    }

    void methodA3() {
        System.out.println("methodA");
        try {
            methodB();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void methodB() throws IOException, ArithmeticException {
        System.out.println("methodB");
        int i = 10 / 0;
    }
}

public class ExceptionThrows {
    public static void main(String[] args) {
        int i = 0;
        SimpleA a = new SimpleA();

        try {
            a.methodA1();
            a.methodA2();
            a.methodA3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
