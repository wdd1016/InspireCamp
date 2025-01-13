package grammar;

public class Variables {

    static class A {
        int m;
        int n;
        void work() {
            int k;
            // System.out.println(k); // 오류가 발생
        }
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m); // 0
        System.out.println(a.n); // 0
        a.work();
    }
}
