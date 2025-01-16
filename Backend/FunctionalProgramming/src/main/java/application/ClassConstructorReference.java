package application;

// 클래스 생성 참조 ⇒ 클래스명::new

@FunctionalInterface
interface RefDefaultConstructor {
    // Cls 클래스의 Cls() 생성자를 이용해서 인스턴스를 생성해서 반환
    Cls getInstance();
}

@FunctionalInterface
interface RefParamConstructor {
    // Cls 클래스의 Cls(int i) 생성자를 이용해서 인스턴스를 생성해서 반환
    Cls getInstance(int i);
}

class Cls {
    Cls() {
        System.out.println("첫번째 생성자");
    }

    Cls(int i) {
        System.out.println("두번째 생성자");
    }
}

public class ClassConstructorReference {
    // 익명 이너 클래스를 이용해서 실행
    public static void main(String[] args) {
        RefDefaultConstructor r1 = new RefDefaultConstructor() {
            @Override
            public Cls getInstance() {
                return new Cls();
            }
        };
        r1.getInstance();       // 첫번째 생성자

        // 람다식을 이용해서 실행
        RefDefaultConstructor r2 = () -> new Cls();
        r2.getInstance();

        // 메서드 참조를 이용해서 실행
        RefDefaultConstructor r3 = Cls::new;
        r3.getInstance();
        System.out.println();

        // 익명 이너 클래스를 이용해서 실행
        RefParamConstructor p1 = new RefParamConstructor() {
            @Override
            public Cls getInstance(int i) {
                return new Cls(i);
            }
        };
        p1.getInstance(100);    // 두번째 생성자

        // 람다식을 이용해서 실행
        RefParamConstructor p2 = i -> new Cls(i);
        p2.getInstance(100);

        // 메서드 참조를 이용해서 실행
        RefParamConstructor p3 = Cls::new;
        p3.getInstance(100);
    }
}
