package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect {
    // 공통 기능을 적용할 대상을 설정
    // calculator 패키지와 그 하위 패키지에 위치한 public 메서드를 Pointcut으로 설정
    //         포인트 컷 지정자(PCD)
    //         execution(modifiers-pattern?
    //                     ret-type-pattern
    //                     declaring-type-pattern?name-pattern(param-pattern)
    //                     throws-pattern?)
    // * : 모든 값, .. : 0개 이상
    // @Pointcut("execution(public * calculator..*(..))")
    // private void publicTarget() {
    //
    // }

    // Around Advice
    // publicTarget() 메서드에 정의한 Pointcut에 공통 기능을 적용
    // measure => 사용자 정의 메서드 => 공통 기능을 구현
    // ProceedingJoinPoint => 프록시 대상 객체의 메서드를 호출할 때 사용
    // @Around("publicTarget()")
    // @Around 어노테이션에 execution 명시자를 직접 지정하는 것도 가능
    // @Around("execution(public * calculator..*(..))")
    @Around("aspect.CommonPointcut.commonTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            // 받은 핵심 기능
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long end = System.nanoTime();

            System.out.printf("%s.%s(%s) 실행결과 = %d \n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    joinPoint.getSignature().getName(),
                    Arrays.toString(joinPoint.getArgs()),
                    (end - start));
        }
    }
}
