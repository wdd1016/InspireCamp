package collection;

// 인덱스가 없고, 데이터의 중복을 허용하지 않음

// Set<E>의 모든 데이터를 하나씩 가져오는 방법
// 1. iterator() 메서드로 Iterator<E> 객체로 반환 받아서 활용
// 2. for-each 구문 이용

// Set<E> 인터페이스를 상속받아 구현한 대표적인 구현 클래스
// ⇒ HashSet<E>, LinkedHashSet<E>, TreeSet<E>

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SetCollection {
    public static void main(String[] args) {
        // 데이터 추가
        Set<String> hset = new HashSet<>();
        hset.add("하나");
        hset.add("둘");
        hset.add("셋");
        System.out.println(hset);   // [둘, 하나, 셋]

        Set<String> hset2 = new HashSet<>();
        hset2.add("하나");
        hset2.add("가");
        hset2.add("나");
        System.out.println(hset2);

        hset.addAll(hset2);
        System.out.println(hset);   // [가, 둘, 나, 하나, 셋]
        System.out.println();

        // 데이터 삭제
        hset.remove("나");
        System.out.println(hset);   // [가, 둘, 하나, 셋]

        hset.clear();
        System.out.println(hset);   // []
        System.out.println();

        // 데이터 정보 추출
        System.out.println(hset.isEmpty());     // true

        hset.add("가");
        hset.add("나");
        hset.add("다");
        System.out.println(hset.contains("나")); // true
        System.out.println(hset.contains("너")); // false

        System.out.println(hset.size());        // 3
        System.out.println();

        Iterator<String> iterator = hset.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        for (String s : hset) {
            System.out.println(s);
        }
        System.out.println();

        // 배열로 변환
        Object[] objArr = hset.toArray();
        System.out.println(Arrays.toString(objArr));    // [가, 다, 나]

        String[] strArr1 = hset.toArray(new String[0]);
        System.out.println(Arrays.toString(strArr1));   // [가, 다, 나]

        String[] strArr2 = hset.toArray(new String[5]);
        System.out.println(Arrays.toString(strArr2));   // [가, 다, 나, null, null]]
    }
}
