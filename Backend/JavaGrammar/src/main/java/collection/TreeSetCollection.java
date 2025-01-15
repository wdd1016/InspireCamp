package collection;

// TreeSet<E> 구현 클래스
// ⇒ 크기에 따른 정렬 및 검색 기능이 추가된 컬렉션
// ⇒ 데이터 입력 순서와 상관없이 크기 순으로 정렬되어 출력

import java.util.Set;
import java.util.TreeSet;

public class TreeSetCollection {
    public static void main(String[] args) {
        Set<Integer> iset = new TreeSet<>();

        iset.add(100);
        iset.add(10);
        iset.add(2);
        iset.add(10);

        System.out.println(iset);   // [2, 10, 100]
    }
}
