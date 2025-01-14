package grammar;

// score 변수 ⇒ 점수를 저장 ⇒ 0 ~ 100 값만 대입이 가능
// ⇒ 범위 밖의 값을 입력했을 때 예외를 발생
// ⇒ 음수인 경우 MinusException을, 100을 초과하는 경우 OverException을 발생

class MinusException extends Exception {
    MinusException() {
    }

    MinusException(String s) {
        super(s);
    }
}

class OverException extends Exception {
    OverException() {
    }

    OverException(String s) {
        super(s);
    }
}

class UserDefineExceptionExampleClass {
    void checkScore(int score) throws MinusException, OverException {
        if (score < 0)
            throw new MinusException("음수값 입력");
        else if (score > 100)
            throw new OverException("100점 초과");
        else
            System.out.println("정상적인 값입니다.");
    }
}

public class UserDefineExceptionExample {
    public static void main(String[] args) {
        UserDefineExceptionExampleClass a = new UserDefineExceptionExampleClass();
        try {
            a.checkScore(55);
            a.checkScore(105);
        } catch (MinusException | OverException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.checkScore(55);
            a.checkScore(-100);
        } catch (MinusException | OverException e) {
            System.out.println(e.getMessage());
        }
    }
}
