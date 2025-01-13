package grammar;

public class StaticMethod {
    void printA() {
        System.out.println("A");
    }

    void printMyA() {
        System.out.print("My");
        printA();
    }

    static void printB() {
        System.out.println("B");
    }

    static void printMyB() {
        System.out.print("My");

        // 해당 메서드가 static으로 정의되어 있어야 호출이 가능
        printB();

        // static으로 정의되어 있지 않으므로 호출이 불가능
        // printA();
    }

    public static void main(String[] args) {
        StaticMethod anInstance = new StaticMethod();
        anInstance.printMyA();

        // 인스턴스를 통해서 메서드를 호출
        anInstance.printMyB();

        // 인스턴스를 생성하지 않고 메서드를 호출
        StaticMethod.printMyB();
    }

}
