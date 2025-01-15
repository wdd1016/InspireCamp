package collection;

import java.util.LinkedHashSet;
import java.util.Set;

// LinkedHashSet<E> 구현 클래스
// ⇒ HashSet<E>을 상속한 클래스로, 연결 정보가 추가
// ⇒ 출력 순서와 입력 순서가 동일

public class LinkedHashSetCollection {
    public static void main(String[] args) {
        Set<Integer> iset = new LinkedHashSet<>();

        iset.add(100);
        iset.add(10);
        iset.add(2);
        iset.add(10);
        System.out.println(iset);   // [100, 10, 2]
    }
}
