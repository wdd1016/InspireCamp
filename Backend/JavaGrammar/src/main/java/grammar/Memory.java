package grammar;

import java.util.Arrays;

public class Memory {
    public static void main(String[] args) {
        int a1;
        // System.out.println(a); -> 오류 발생

        // 힙 메모리는 디폴트 초기값이 강제 설정 (숫자: 0 / boolean: false / 참조 자료형: null)
        int[] a2 = new int[3];
        System.out.println(Arrays.toString(a2));	// [0, 0, 0]

        boolean[] b1 = new boolean[3];
        System.out.println(Arrays.toString(b1));	// [false, false, false]

        String[] c1 = new String[3];
        System.out.println(Arrays.toString(c1));	// [null, null, null]

        int x = 10;
        int y = x;
        System.out.println(x + " : " + y);		// 10 : 10

        x = 20;
        System.out.println(x + " : " + y);		// 20 : 10

        int[] a3 = { 1, 2, 3 };
        int[] b2 = a3;					// 배열 주소의 복사
        System.out.println(Arrays.toString(a3));	// [1, 2, 3]
        System.out.println(Arrays.toString(b2));	// [1, 2, 3]

        a3[1] = 200;
        System.out.println(Arrays.toString(a3));	// [1, 200, 3]
        System.out.println(Arrays.toString(b2));	// [1, 200, 3]
    }
}
