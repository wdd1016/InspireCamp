package grammar; // 패키지 ⇐ 주석을 제외하고 첫 번째 줄에 위치
                 //         디폴트 패키지를 사용하면 생략이 가능

import java.util.Arrays; // 임포트 ⇐ 다른 패키지의 클래스를 사용할 때 사용

class AnotherClass {     // 외부 클래스 ⇐ public 키워드를 사용할 수 없음
    int a;
}

public class ClassStructure {
    int[] b = {1, 3};    // 필드 ⇐ 클래스의 특징(속성)을 나타내는 변수

    float func() {       // 메서드 ⇐ 클래스가 지니고 있는 기능(함수)
        InnerClass innerClass = new InnerClass();

        System.out.println(Arrays.toString(b));
        return innerClass.coco();
    }

    ClassStructure() {    // 생성자 ⇐ 클래스의 객체를 생성하는 역할
        b[0] = 2;
    }

    class InnerClass {    // 내부 클래스
        int c = 3;
        public int coco() { return c; }
    }

    public static void main(String[] args) {
        ClassStructure classStructure = new ClassStructure();
        System.out.println(classStructure.func());
    }
}

// 클래스 멤버 = 필드 + 메서드 + 내부 클래스