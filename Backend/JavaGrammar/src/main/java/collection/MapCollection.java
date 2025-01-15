package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// Map<K, V> 컬렉션 인터페이스
// Key, Value 한 쌍으로 데이터를 저장
// Key 는 중복 저장 불가, Value 는 중복이 가능

// Map<K, V> 인터페이스를 구현한 대표 구현 클래스
// ⇒ HashMap<K, V>, LinkedHashMap<K, V>, Hashtable<K, V>, TreeMap<K, V>

// HashMap<K, V> 구현 클래스
// Key 값의 중복 여부를 확인하는 방법
// ⇒ Key 객체의 hashCode() 값이 같고, equals() 메서드가 true 를 반환하면 같은 객체로 인식하고, 그 외는 다른 객체로 간주

// Hashtable<K, V> ⇒ 동기화 메서드로 구현되어 있으므로 멀티 쓰레드에서도 안전하게 동작
// LinkedHashMap<K, V> ⇒ 입력 순서 데로 출력
// TreeMap<K, V> ⇒ 데이터를 Key 순으로 정렬해서 저장 ⇒ Key 객체는 크기를 비교하는 기준을 가지고 있어야 함

// Stack<E> 컬렉션 클래스 ⇒ 후입선출(LIFO) 자료구조를 구현한 컬렉션

// Queue<E> 컬렉션 인터페이스 ⇒ 선입선출(FIFO) 동작을 정의

public class MapCollection {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();

        // 데이터 추가
        hashMap.put(2, "두번째");
        hashMap.put(1, "첫번째");
        hashMap.put(3, "세번째");
        System.out.println(hashMap);   // {1=첫번째, 2=두번째, 3=세번째}

        Map<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(1, "FIRST");
        hashMap2.put(4, "FOURTH");

        hashMap.putAll(hashMap2);
        System.out.println(hashMap);   // {1=FIRST, 2=두번째, 3=세번째, 4=FOURTH}
        System.out.println();

        // 데이터 정보 조회
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(4));

        System.out.println(hashMap.containsKey(1));    // true
        System.out.println(hashMap.containsKey(5));    // false

        System.out.println(hashMap.containsValue("첫번째"));  // false
        System.out.println(hashMap.containsValue("FIRST"));   // true

        Set<Integer> keySet = hashMap.keySet();
        System.out.println(keySet);         // [1, 2, 3, 4]

        Set<Entry<Integer, String>> entrySet = hashMap.entrySet();
        System.out.println(entrySet);       // [1=FIRST, 2=두번째, 3=세번째, 4=FOURTH]

        System.out.println(hashMap.size());    // 4
        System.out.println();

        // 데이터 삭제
        System.out.println(hashMap.remove(4));
        System.out.println(hashMap.remove(40)); // 존재하지 않는 키를 이용해서 삭제 => 동작하지 않음
        System.out.println(hashMap);                 // {1=FIRST, 2=두번째, 3=세번째}
        System.out.println();

        System.out.println(hashMap.remove(2, "두번째"));
        System.out.println(hashMap.remove(1, "첫번째"));                   // 존재하지 않는 키, 값 쌍 => 동작하지 않음
        System.out.println(hashMap);                // {1=FIRST, 3=세번째}
        System.out.println();

        hashMap.clear();
        System.out.println(hashMap);                // {}
    }
}
