package collection;

// List<E> 인터페이스를 구현한 대표적인 클래스
// ⇒ ArrayList<E>, Vetor<E>, LinkedList<E>

import java.util.*;

public class ListCollection {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>(30);
        // vector : 동기화되는(Thread safe) ArrayList
        List<Integer> vector1 = new Vector<>();
        List<Integer> vector2 = new Vector<>(30);
        List<Integer> linked1 = new LinkedList<>();
        // LinkedList는 capacity 지정이 불가능
        // List<Integer> linked2 = new LinkedList<>(30);

        // Arrays.asList() 메서드를 이용해서 List 타입의 참조변수에 값을 할당
        // ⇒ 저장 공간의 크기를 변경할 수 없음
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(list);   // [1, 2, 3, 4]
        list.set(1, 20);
        System.out.println(list);   // [1, 20, 3, 4]
        // java.lang.UnsupportedOperationException
        // list.add(50);
        // list.remove(0);
    }
}
