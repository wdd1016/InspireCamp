package grammar;

public class DynamicParameter {
    public static void dynamicParameter(int... numbers) {
        System.out.println("매개변수의 길이 >>> " + numbers.length);
        for (int no : numbers) {
            System.out.println(no);
        }
    }

    public static void main(String[] args) {
        DynamicParameter.dynamicParameter(1, 2, 3);
        DynamicParameter.dynamicParameter(10, 20, 30, 40, 50);
    }
}
