package ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 기존 자바와 Spring의 차이
        Greeter greeter1 = new Greeter();
        greeter1.setFormat("Hello, %s!!!");
        String message1 = greeter1.greet("Spring");
        System.out.println(message1);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        Greeter greeter2 = context.getBean("greeter", Greeter.class);
        greeter2.setFormat("안녕, %s!!!");
        String message2 = greeter2.greet("스프링");
        System.out.println(message2);
        System.out.println();

        // Bean의 Singleton
        Greeter g1 = new Greeter();
        Greeter g2 = new Greeter();
        System.out.println("g1 == g2 : " + (g1 == g2));

        Greeter g3 = context.getBean("greeter", Greeter.class);
        Greeter g4 = context.getBean("greeter", Greeter.class);
        System.out.println("g3 == g4 : " + (g3 == g4));
        context.close();
    }
}
