package calculator;


public class RecCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        if (num == 1)
            return 1;

        return num * factorial(num - 1);
    }
}

// RecCalculator 클래스 내부에는 실행 시간 출력 적용이 불가
// ⇒ 재귀호출 방식이므로 시작과 끝 시간을 측정하는 것이 불가
// public class ImpCalculator implements Calculator {
//     @Override
//     public long factorial(long num) {
//         long start = System.nanoTime();
//
//         long result = 1;
//         for (long i = 1; i <= num; i++) { result *= i; }
//
//         long end = System.nanoTime();
//         System.out.printf("ImpCalculator.factorial(%d) 실행시간 = %d\n", num, (end - start));
//
//         return result;
//     }
// }
