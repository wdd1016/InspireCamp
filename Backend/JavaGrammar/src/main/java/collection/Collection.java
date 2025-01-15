package collection;

// 컬렉션
// 데이터의 저장 용량(capacity, 저장할 수 있는 최대 데이터의 개수)을 동적으로 관리

// 컬렉션 프레임워크
// ⇒ 리스트, 스택, 큐, 트리 등의 자료구조에 정렬, 탐색 등의 알고리즘을 구조화해 놓은 프레임워크

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        // 배열
        String[] strArr = new String[]{"가", "나", "다", "라"};
        System.out.println(strArr.length);              // 4
        strArr[2] = null;
        strArr[3] = null;
        System.out.println(strArr.length);              // 4
        System.out.println(Arrays.toString(strArr));    // [가, 나, null, null]
        System.out.println();

        // 리스트
        List<String> arrList = new ArrayList<>();
        arrList.add("가");
        arrList.add("나");
        arrList.add("다");
        arrList.add("라");
        System.out.println(arrList.size()); // 4
        arrList.remove("라");
        arrList.remove(2);
        System.out.println(arrList.size()); // 2
        System.out.println(arrList);        // [가, 나]
    }
}
