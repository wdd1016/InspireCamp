package grammar;

// 개발자가 해결할 수 있는 오류 = 예외(exception)
// 연산 오류, 포맷 오류, ... 등

// cf) 에러(error) = 자바 가상 머신 자체에서 발생하는 오류 = 개발자가 해결할 수 없는 오류

// 예외 - 일반 예외, 런타임 예외

// 예외 처리
// try {
//	     // 예외 발생 가능 코드
// } catch (예외클래스이름 참조변수이름) {
//	     // 예외가 발생했을 때 처리
// } catch (예외클래스이름 참조변수이름) {
//	     // 예외가 발생했을 때 처리
// } finally {
//	     // 예외 발생 여부와 관계 없이 실행되는 코드
//	     // 리소스 해제와 같은 정리 코드를 기술
// }

public class ExceptionClass {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt("오십");
            System.out.println(3 / 0);
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println("오류가 발생했습니다. ");
        } catch (Exception e) {
            System.out.println("오류 발생");
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }

        // 올바른 예외 처리 ⇒ 발생 가능한 예외를 세분화해서 발생할 수 있는 순서대로 기술
        try {
            int i = Integer.parseInt("오십");
            System.out.println(3 / 0);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 변환할 수 없습니다.");
        } catch (ArithmeticException e) {
            System.out.println("숫자는 0으로 나눌 수 없습니다.");
        } catch (Exception e) {
            System.out.println("오류 발생");
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
