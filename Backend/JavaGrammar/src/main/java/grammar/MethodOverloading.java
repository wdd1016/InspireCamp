package grammar;

public class MethodOverloading {
    public static void main(String[] args) {
        // System.out.println() => 인자값을 콘솔에 출력하고 개행문자를 처리
        System.out.println();        // 한 줄 띄우기
        System.out.println("문자열");
        System.out.println(1234);
        System.out.println(true);

        // System.out.print() => 인자값을 콘솔에 출력
        System.out.print("문자열");
        System.out.print(1234);
        System.out.print(true);

        // 개행문자(\n)를 출력
        System.out.print("개행문자를 포함\n");
        System.out.print("다음 줄에 출력\n");

        // System.out.printf() => 형식 문자열을 이용해서 출력
        //                        ~~~~~~~~~~~
        //                        데이터의 출력 형식을 지정하는 %로 시작하는 문자열
        System.out.printf("%s 문자열 출력\n", "이것은 문자열입니다.");
        System.out.printf("%d 숫자 출력\n", 1234);
        System.out.printf("%d : %f : %4.2f\n", 100, 15.66666, 15.66666);
    }
}
