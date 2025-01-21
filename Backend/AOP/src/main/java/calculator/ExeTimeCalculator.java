package calculator;

// 프록시 객체 ⇒ 핵심 기능을 구현하지 않는 대신 여러 객체에 공통적으로 적용할 수 있는 기능을 구현
// 실행 시간을 계산하는 객체를 생성

public class ExeTimeCalculator implements Calculator {
    private final Calculator delegate;

    public ExeTimeCalculator(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public long factorial(long num) {
        long start = System.nanoTime();
        long result = delegate.factorial(num);
        long end = System.nanoTime();

        System.out.printf("%s.factorial(%d) 실행시간 = %d\n",
                this.delegate.getClass().getSimpleName(), num, (end - start));
        return result;
    }
}
