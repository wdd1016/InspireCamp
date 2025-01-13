package grammar;
import java.util.Arrays;

public class ArrayClass {
    public static void printArray(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public static void main(String[] args) {
        // 선언과 할당을 분리할 수 있음
        int[] i1 = new int[3];
        i1[0] = 1;
        i1[1] = 2;
        i1[2] = 3;
        System.out.println(Arrays.toString(i1));

        int[] i2;
        i2 = new int[3];
        i2[0] = 1;
        i2[1] = 2;
        i2[2] = 3;
        System.out.println(Arrays.toString(i2));

        int[] x1 = new int[] { 4, 5, 6 };
        System.out.println(Arrays.toString(x1));

        int[] x2;
        x2 = new int[] { 4, 5, 6 };
        System.out.println(Arrays.toString(x2));


        // 선언과 할당을 분리할 수 없음
        int[] y1 = { 7, 8, 9 };
        System.out.println(Arrays.toString(y1));

        int[] y2;
        // Array constants can only be used in initializers
        // y2 = { 7, 8, 9 };

        int[] a1 = new int[100];
        for (int index = 0; index < a1.length; index ++) {
            System.out.println(a1[index]);
        }

        int[] a2 = new int[100];
        for (int element: a2) {
            System.out.println(element);
        }

        int[] a = { 1, 2, 3 };
        printArray(a);

        printArray(new int[] { 1, 2, 3 });

//      printArray({1, 2, 3});
    }

}
