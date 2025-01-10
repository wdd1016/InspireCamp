package com.test;


// Java 파일명과 동일한 클래스에만 public 접근 지정자를 붙일 수 있음
public class MyTest {    // MyTest.class

    public static void main(String[] args) {
        System.out.println("문자열");
    }
}

class A {                // A.class

}

class B {                // B.class
    class C {            // B$C.class <= 내부 클래스
    }
}
