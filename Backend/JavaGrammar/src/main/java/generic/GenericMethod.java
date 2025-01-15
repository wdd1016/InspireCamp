package generic;

// 제네릭 메서드
// 리턴타입 또는 매개변수의 타입을 제네릭 타입으로 선언

// 제네릭 타입 변수명이 1개인 경우
// 접근지정자 <T> T 메서드명(T t) {  ...  }
// 제네릭 타입 변수명이 2개인 경우
// 접근지정자 <T, V> T 메서드명(T t, V v) { ... }
// 매개변수에만 제네릭이 사용되는 경우
// 접근지정자 <T> 반환타입 메서드명(T t) { ... }
// 리턴 타입에만 제네릭이 사용되는 경우
// 접근지정자 <T> T 메서드명(int a) { ... }

class GenericMethodClass {
    public <T> T method1(T t) {
        return t;
    }

    public <T> boolean method2(T t1, T t2) {
        return t1.equals(t2);
    }

    public <K, V> void method3(K k, V v) {
        System.out.println(k + " : " + v);
    }

    // 제네릭 메서드 안에는 기본적으로 Object에서 물려받은 메서드만 사용이 가능
    public <T> T method4(T t) {
        // The method length() is undefined for the type T
        // int stringLength = t.length();

        String classDescription = t.toString();
        return t;
    }
}


public class GenericMethod {
    public static void main(String[] args) {
        GenericMethodClass gm = new GenericMethodClass();

        // 제네릭 메서드를 호출할 때 호출할 메서드 앞에 <실제제네릭타입>을 추가해야 함
        // 참조객체.<실제제네릭타입>메서드명(매개변수);
        String s = gm.<String>method1("문자열");
        System.out.println(s);

        int i = gm.<Integer>method1(123);
        System.out.println(i);

        boolean b = gm.<String>method2("안녕", "안녕");
        System.out.println(b);

        gm.<String, Integer>method3("첫번째", 123);
        gm.<Integer, String>method3(123, "두번째");
        System.out.println();

        // 매개변수 값으로 제네릭 타입을 유추할 수 있는 경우, 제네릭 타입 지정을 생략할 수 있음
        GenericMethodClass gm2 = new GenericMethodClass();

        String s2 = gm.method1("문자열");
        System.out.println(s);

        int i2 = gm.method1(123);
        System.out.println(i);

        boolean b2 = gm.method2("안녕", "안녕");
        System.out.println(b);

        gm.method3("첫번째", 123);
        gm.method3(123, "두번째");
    }
}
