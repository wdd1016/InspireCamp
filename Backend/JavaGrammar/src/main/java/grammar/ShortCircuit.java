package grammar;

public class ShortCircuit {
    public static void main(String[] args) {
        // | 연산 => 모든 연산을 수행 후 결과를 비교
        // java.lang.NullPointerException 예외가 발생
        String s1 = null;
        try {
            if (5 > 3 | s1.equals("abc")) {
                System.out.println("^^;;;");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        // || 연산 => 결과가 확정되면 연산을 생략하므로 예외가 발생하지 않음
        String s2 = null;
        if (5 > 3 || s2.equals("abc")) {
            System.out.println("^^;;;");
        }
    }
}
