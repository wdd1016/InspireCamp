package exercise;

// Q4
// 다음은 abc() 추상 메서드를 갖고 있는 함수형 인터페이스 D 객체를 익명 이너 클래스 방법으로 생성한 코드다.
// 구현 메서드의 내부에서는 문자열을 정수로 변환하는 Integer 클래스의 정적 메서드인 parseInt() 메서드로
// 매개변수를 그대로 넘겨 호출했다. 이때 다음 코드를 정적 메서드를 참조하는 람다식 문법을 사용해 변경하시오.
//
//         D d1 = new D() {
//             @Override
//             public int abc(String str) {
//                 return Integer.parseInt(str);
//             }
//         };
//         System.out.println(d1.abc("12345"));    // 12345

@FunctionalInterface
interface D {
    int abc(String str);
}

public class Question4 {
    public static void main(String[] args) {
        D d2 = str -> Integer.parseInt(str);
        System.out.println(d2.abc("12345"));

        D d3 = Integer::parseInt;
        System.out.println(d3.abc("12345"));
    }
}
