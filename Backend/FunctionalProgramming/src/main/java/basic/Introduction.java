package basic;

// 함수형 프로그래밍

// 프로그램을 함수들의 조합으로 만드는 방식
//            ~~~~
//            동일한 입력값을 넣으면 동일한 결과를 반환 → 순수 함수(pure function)

// 데이터나 상태를 변경하지 않고 새로운 값을 반환 → 비상태, 불변성(stateless, immutability)
// 선언형 프로그래밍 ⇒ 무엇(what)을 해야 하는지에 집중하며, 어떻게(how) 할지를 명시하지 않음

import java.util.AbstractMap.SimpleEntry;

public class Introduction {
    private int num = 1;
    private SimpleEntry<String, Integer> person = new SimpleEntry<>("age", 23);

    // 순수하지 못한 함수
    int add(int a) {
        return a + num;
    }

    // 순수 함수
    int pureAdd(int a, int b) {
        return a + b;
    }

    // 상태, 변화 있음
    SimpleEntry<String, Integer> increaseAge(SimpleEntry<String, Integer> person) {
        person.setValue(person.getValue() + 1);
        return person;
    }

    // 비상태, 불변성(stateless, immutability)
    SimpleEntry<String, Integer> pureIncreaseAge(SimpleEntry<String, Integer> person) {
        SimpleEntry<String, Integer> newPerson = new SimpleEntry<>(person.getKey(), person.getValue());
        newPerson.setValue(newPerson.getValue() + 1);
        return newPerson;
    }


    public static void main(String[] args) {
        // 순수하지 못한 함수 : num = 1일 때 add(10)의 결과와 num = 2일 때 add(10)의 결과가 상이
        Introduction introduction = new Introduction();
        System.out.println(introduction.add(10));
        introduction.num = 2;
        System.out.println(introduction.add(10));
        System.out.println();

        // 순수 함수 : 함수의 실행결과는 항상 동일 (side effect 없음)
        System.out.println(introduction.pureAdd(10, 20));
        introduction.num = 3;
        System.out.println(introduction.pureAdd(10, 20));
        System.out.println();

        // 상태, 변화 있음
        System.out.println(introduction.person.getValue());
        System.out.println(introduction.increaseAge(introduction.person).getValue());
        System.out.println(introduction.person.getValue());
        System.out.println();

        // 비상태, 불변성(stateless, immutability)
        System.out.println(introduction.person.getValue());
        System.out.println(introduction.pureIncreaseAge(introduction.person).getValue());
        System.out.println(introduction.person.getValue());
        System.out.println();
    }
}
