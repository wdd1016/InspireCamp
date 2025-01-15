package collection;

// ArrayList<E> 구현 클래스
// List<E> 인터페이스를 구현한 구현 클래스
// 배열처럼 수집(collect)한 원소(element)를 인덱스(index)로 관리하며, 저장 용량(capacity)을 동적으로 관리

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListCollection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // 데이터 추가 >>> add(value), add(index, value)
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);               // [3, 4, 5]
        System.out.println(list.toString());    // [3, 4, 5]

        // 데이터를 해당 인덱스에 추가하고, 나머지는 밀린다.
        list.add(1, 40);
        System.out.println(list);               // [3, 40, 4, 5]

        List<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(200);

        // 컬렉션 객체 추가 >>> addAll(values), addAll(index, values)
        list.addAll(list2);
        System.out.println(list);               // [3, 40, 4, 5, 100, 200]

        list.addAll(1, list2);
        System.out.println(list);               // [3, 100, 200, 40, 4, 5, 100, 200]

        // 데이터 변경 >>> set(index, value)
        list.set(1, 111);
        System.out.println(list);               // [3, 111, 200, 40, 4, 5, 100, 200]
        // java.lang.IndexOutOfBoundsException: Index 8 out of bounds for length 8
        // list.set(8, 8888);

        // 데이터 삭제 >>> remove(index), remove(value) : 인덱스 재조정됨
        list.remove(1);
        System.out.println(list);               // [3, 200, 40, 4, 5, 100, 200]
        list.remove(1);
        System.out.println(list);               // [3, 40, 4, 5, 100, 200]

        // 그냥 숫자를 넣으면 index 로 인식하기 때문에, Integer 로 래핑해야 함
        list.remove(Integer.valueOf(100));
        System.out.println(list);               // [3, 40, 4, 5, 200]

        list.add(40);
        System.out.println(list);               // [3, 40, 4, 5, 200, 40]
        // 중복이 있는 경우, 앞에 있는 1개만 삭제
        list.remove(Integer.valueOf(40));
        System.out.println(list);               // [3, 4, 5, 200, 40]

        list.clear();
        System.out.println(list);               // []


        // 데이터 정보 조회
        System.out.println(list.isEmpty());     // true

        list.add(1);
        list.add(2);
        System.out.println("리스크의 크기 : " + list.size()); // 2
        System.out.println("1번째 : " + list.get(0));         // 1

        // 배열로 변환
        Object[] o = list.toArray();
        System.out.println(Arrays.toString(o));     // [1, 2]

        Integer[] i1 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(i1));    // [1, 2]

        // list.toArray(parameter)의 경우에는, parameter 배열을 참조하여 리스트 내용 복사 후 리턴
        // => parameter 요소 변경과 리턴 배열 요소 변경은 연결됨
        Integer[] anIntegerArray1 = new Integer[4];
        Integer[] i2 = list.toArray(anIntegerArray1);
        System.out.println(Arrays.toString(i2));    // [1, 2, null, null]
        System.out.println(Arrays.toString(anIntegerArray1));
        System.out.println();

        // 단, 매개변수의 크기보다 리스트의 크기가 큰 경우, 타입만 결정하고 별도의 배열 생성
        Integer[] anIntegerArray2 = new Integer[1];
        Integer[] i3 = list.toArray(anIntegerArray2);
        System.out.println(Arrays.toString(i3));    // [1, 2, null, null]
        System.out.println(Arrays.toString(anIntegerArray2));
    }
}
