package grammar;

public class StrictDataType {
    public static void main(String[] args) {
        // 변수 선언 시 변수가 가지는 데이터 타입을 지정
        int a;

        a = 123;
//      a = 123.0;	// Type mismatch: cannot convert from double to int
//      a = "abc";	// Type mismatch: cannot convert from String to int

    }
}
