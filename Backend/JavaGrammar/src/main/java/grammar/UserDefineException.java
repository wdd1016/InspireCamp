package grammar;

// 사용자 정의 예외 클래스 작성 ⇒ Exception을 상속 받아서 일반 예외 클래스를 만드는 방법,
// RuntimeException을 상속 받아서 실행 예외 클래스를 만드는 방법이 있음

class MyException extends Exception {
    MyException() {
    }

    MyException(String s) {
        super(s);
    }
}

class MyRuntimeException extends RuntimeException {
    MyRuntimeException() {
    }

    MyRuntimeException(String s) {
        super(s);
    }
}

class UserDefineExceptionClass {
    void abc() throws NumberFormatException {
        bcd();
    }

    void bcd() throws NumberFormatException {
        cde();
    }

    void cde() throws NumberFormatException {
        Integer.parseInt("하나둘셋");
    }
}


public class UserDefineException {
    public static void main(String[] args) throws MyException {
        MyException myException1 = new MyException();
        MyException myException2 = new MyException("예외 메시지");

        // try {
        //     throw myException2;
        // } catch (MyException e) {
        //     e.printStackTrace();
        // }

        UserDefineExceptionClass exceptionA = new UserDefineExceptionClass();
        try {
            exceptionA.abc();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
