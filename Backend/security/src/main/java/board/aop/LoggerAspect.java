package board.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component  // SpringBoot에서는 @EnableAspectAutoProxy 어노테이션을 추가하지 않아도 자동으로 AOP를 활성화
public class LoggerAspect {
    @Pointcut("execution(* board.controller..*.*(..))"
            + " || execution(* board.service..*.*(..))"
            + " || execution(* board.repository..*.*(..))"
            + " || execution(* board.common..*.*(..))")
    private void loggerTarget() {

    }

    @Around("loggerTarget()")
    public Object logPrinter(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        log.debug(" >>> " + className + "." + methodName);
        return joinPoint.proceed();
    }
}
