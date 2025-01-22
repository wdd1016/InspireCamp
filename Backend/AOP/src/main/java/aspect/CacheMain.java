package aspect;

import calculator.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CacheMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectContext.class);

        Calculator rec = context.getBean("recCalculator", Calculator.class);
        System.out.println(rec.factorial(10));
        System.out.println(rec.factorial(10));
        System.out.println(rec.factorial(7));
        System.out.println(rec.factorial(7));
        System.out.println(rec.factorial(5));

        context.close();
    }
}
