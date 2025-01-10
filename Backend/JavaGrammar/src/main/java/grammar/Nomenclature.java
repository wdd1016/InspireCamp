package grammar;

public class Nomenclature {
    public static void main(String[] args) {
        // 변수 명명법
        boolean aBcD;        // O 가능하지만 권고 위배
        byte 가나다;        // O
        short _abcd;        // O
        char $ab_cd;        // O
//      int 3abcd;			// X 숫자로 시작
        long abcd3;        // O
//      float int;			// X 예약어를 사용
        double main;        // O
//      int my Work;		// X 공백을 포함
        String myClassName;    // O
        int ABC;            // O 가능하지만 권고 위배 (상수 표기법)

        // 상수 명명법
        final double PI;    // O
        final int MY_DATA;    // O
        final float myData; // O 가능하지만 권고 위배 (변수 표기법)
    }
}
