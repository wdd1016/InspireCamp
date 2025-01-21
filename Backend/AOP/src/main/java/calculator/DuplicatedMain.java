package calculator;


public class DuplicatedMain {
    // 시간 계산 방식과 출력 방식에 코드 중복이 발생
    // 시간 계산 방식과 출력 방식에 변경이 필요하면 모든 중복 부분을 수정해야 함
    // 일관되게 변경이나 정책을 반영하는 것이 어려움
    public static void main(String[] args) {
        final int num = 1000;

        ImpCalculator imp = new ImpCalculator();
        long start1 = System.nanoTime();
        imp.factorial(num);
        long end1 = System.nanoTime();
        System.out.printf("ImpCalculator.factorial(%d) 실행시간 = %d\n", num, (end1 - start1));

        RecCalculator rec = new RecCalculator();
        long start2 = System.nanoTime();
        rec.factorial(num);
        long end2 = System.nanoTime();
        System.out.printf("RecCalculator.factorial(%d) 실행시간 = %d\n", num, (end2 - start2));
    }
    // 프록시 객체 ⇒ 핵심 기능을 구현하지 않는 대신 여러 객체에 공통적으로 적용할 수 있는 기능을 구현
}
