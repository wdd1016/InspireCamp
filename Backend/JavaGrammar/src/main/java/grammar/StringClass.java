package grammar;

public class StringClass {
    public static void main(String[] args) {
        String str1 = new String("안녕");
        String str2 = new String("안녕");
        String str3 = "안녕";
        String str4 = "안녕";

        // == operator는 참조 주소 비교
        System.out.println(str1 == str2);	// false
        System.out.println(str1 == str3);	// false
        System.out.println(str3 == str4);	// true

        // equals()은 String클래스의 오버라이드 때문에 값 비교
        System.out.println(str1.equals(str2));	// true
        System.out.println(str1.equals(str3));	// true
        System.out.println(str3.equals(str4));	// true

        // Hash Collection에서의 비교에는 hashCode()의 리턴 값 일치와 함께
        // equals() 리턴 값이 true여야 동등하다고 판단한다.
    }
}
