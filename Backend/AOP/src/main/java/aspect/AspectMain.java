package aspect;

import calculator.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectContext.class);

        Calculator imp = context.getBean("impCalculator", Calculator.class);
        System.out.println(imp.factorial(10));
        Calculator rec = context.getBean("recCalculator", Calculator.class);
        System.out.println(rec.factorial(10));

        context.close();
    }
}
