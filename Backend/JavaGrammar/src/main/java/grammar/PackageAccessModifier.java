// 클래스 외부 구성 요소 - 패키지(package)
// 동일한 목적으로 만들어진 클래스들을 묶어(동일한 공간(폴더)) 관리하는 것
// ⇒ 클래스명의 충돌을 방지 ⇒ 클래스의 풀네임(full name) ⇒ 패키지명.클래스명
package grammar;
import abc.bcd.Test;
import com.test.*;

// 외부 클래스(external class)
// public 클래스 외부에 정의한 클래스
// 외부 클래스는 같은 패키지 안에서만 사용할 수 있음 ⇐ default 접근 지정자를 가지는 클래스
class ExternalClass {
    int a = 3;
}

// 접근 지정자
// 자바 제어자의 한 종류로, 클래스, 멤버(필드, 메서드, 인너 클래스), 생성자 앞에 위치
// 사용 범위를 정의
// 클래스의 접근 지정자 ⇒ public, default
public class PackageAccessModifier {
    // public : 동일 패키지의 모든 클래스 + 다른 패키지의 모든 클래스에서 사용 가능
    public void publicFunction() {
        System.out.println("publicFunction");
    }

    // protected : 동일 패키지의 모든 클래스 + 다른 패키지의 자식 클래스에서 사용 가능
    protected void protectedFunction() {
        System.out.println("protectedFunction");
    }

    // default : 동일 패키지의 모든 클래스에서 사용 가능
    void packageFunction() {
        System.out.println("default(package)Function");
    }

    // 동일 클래스 내부에서만 사용 가능
    private void privateFunction() {
        System.out.println("privateFunction");
    }

    public static void main(String[] args) {
        PackageAccessModifier accessModifier = new PackageAccessModifier();

        accessModifier.publicFunction();
        accessModifier.protectedFunction();
        accessModifier.packageFunction();
        // accessModifier.privateFunction(); // impossible
    }
}
