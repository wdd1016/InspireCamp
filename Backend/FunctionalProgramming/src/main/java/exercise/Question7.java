package exercise;

// Q7
// 다음과 같이 클래스 K 내부에는 정수값 하나를
// 입력받는 bcd(int k) 인스턴스 메서드가 정의돼 있다.

class K {
    void bcd(int k) {
        System.out.println(k);
    }
}

// 다음과 같이 람다식을 이용해 인터페이스 G 객체를 생성한 후
// abc(b, 3)를 호출하면 3이 출력된다. 이때 인터페이스 G를 작성하시오.

interface G {
    void abc(K k, int n);
}

public class Question7 {
    public static void main(String[] args) {
        G g1 = K::bcd;
        K k = new K();
        g1.abc(k, 3);    // 3

        G g2 = new G() {
            @Override
            public void abc(K k, int n) {
                k.bcd(n);
            }
        };
        g2.abc(k, 3);
    }
}
