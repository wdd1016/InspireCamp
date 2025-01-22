package aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
    @Pointcut("execution(public * calculator..*(..))")
    public void commonTarget() {
    }
}
