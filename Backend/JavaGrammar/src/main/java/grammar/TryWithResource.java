package grammar;

import java.io.IOException;
import java.io.InputStreamReader;

// try-with-resource 구문을 사용하기 위해서는
// AutoCloseable 인터페이스를 상속받아 close 메서드를 구현해야 함
class TryA implements AutoCloseable {
    String resource;

    TryA(String resource) {
        this.resource = resource;
    }

    @Override
    public void close() throws Exception {
        resource = null;
        System.out.println("리소스 해제");
    }
}

public class TryWithResource {
    public static void main(String[] args) {
        // 기존 방법
        InputStreamReader is = null;
        try {
            is = new InputStreamReader(System.in);
            System.out.println(is.read());
        } catch (
                IOException e) {

        } finally {    // ⇐ finally 구문을 이용해서 try 블록에서 생성한 리소스를 해제
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {

                }
            }
        }

        // 리소스 자동 해제 예외 처리 ⇒ try-with-resource 구문
        try (InputStreamReader is2 = new InputStreamReader(System.in)) {
            System.out.println(is2.read()); // ⇐ try 블록을 빠져나갈 때 자동으로 해제 : close() 메서드를 호출
        } catch (IOException e) {

        }

        try (TryA a = new TryA("리소스")) {

        } catch (Exception e) {

        }
    }
}
