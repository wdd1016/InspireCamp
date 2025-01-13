package grammar;
import java.util.Arrays;

// 참고: 관련된 보안약점
//      public 메서드로부터 반환된 private 배열 ⇒ getter 메서드를 잘못 구현했을 때 발생
//      private 배열에 public 데이터 할당 ⇒ setter 메서드를 잘못 구현했을 때 발생

public class ReferenceGetterSetterWeakness {
    class ArrayTest {
        private int[] myData = { 1, 2, 3 };

        // getter => 필드 데이터를 반환하는 메서드
        public int[] getMyData() {
            return myData;
        }

        // setter => 필드에 데이터를 설정하는 메서드
        public void setMyData(int[] data) {
            this.myData = data;
        }

        public void printMyData() {
            System.out.println(Arrays.toString(this.myData));
        }
    }

    public static void main(String[] args) {
        ReferenceGetterSetterWeakness referenceGetterSetterWeakness = new ReferenceGetterSetterWeakness();
        ArrayTest test = referenceGetterSetterWeakness.new ArrayTest();

        System.out.println("public 메서드로부터 반환된 private 배열 ⇒ getter 메서드를 잘못 구현했을 때 발생");
        int[] outerData = test.getMyData();
        System.out.println(Arrays.toString(outerData));

        outerData[1] = 200;
        System.out.println(Arrays.toString(outerData));

        test.printMyData();
        System.out.println();

        System.out.println("private 배열에 public 데이터 할당 ⇒ setter 메서드를 잘못 구현했을 때 발생");
        int[] outerArray = {100, 200, 300};
        test.setMyData(outerArray);
        test.printMyData();

        outerArray[1] = 20000;
        test.printMyData();
    }
}
