package application;

import java.util.Arrays;

// 배열 생성자 참조 ⇒ 배열타입[]::new

@FunctionalInterface
interface Arr {
    // 매개변수로 전달된 len 크기의 int[]를 반환
    int[] createArray(int len);
}

public class ArrayConstructorReference {
    public static void main(String[] args) {
        // 구현 클래스 정의 후 인스턴스를 생성해서 실행
        class ArrClass implements Arr {
            @Override
            public int[] createArray(int len) {
                return new int[len];
            }
        }
        Arr arr1 = new ArrClass();
        System.out.println(Arrays.toString(arr1.createArray(3)));   // [0, 0, 0]

        // 익명 이너 클래스를 이용해서 실행
        Arr arr2 = new Arr() {
            @Override
            public int[] createArray(int len) {
                return new int[len];
            }
        };
        System.out.println(Arrays.toString(arr2.createArray(3)));

        // 람다식을 이용해서 실행
        Arr arr3 = len -> new int[len];
        System.out.println(Arrays.toString(arr3.createArray(3)));

        // 메서드 참조를 이용해서 실행
        Arr arr4 = int[]::new;
        System.out.println(Arrays.toString(arr4.createArray(3)));
    }
}
