package com.example.board.aop;

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
    @Pointcut("execution(* com.example.board..controller.*Controller.*(..)) || execution(* com.example.board..service.*ServiceImpl.*(..)) || execution(* com.example.board..mapper.*Mapper.*(..))")
    private void loggerTarget() {

    }

    @Around("loggerTarget()")
    public Object logPrinter(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = "";
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        if (className.contains("Controller")) {
            type = "[Controller]";
        } else if (className.contains("Service")) {
            type = "[Service]";
        } else if (className.contains("Mapper")) {
            type = "[Mapper]";
        }
        log.debug(type + " " + className + "." + methodName);
        return joinPoint.proceed();
    }
}
