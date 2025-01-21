package member_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 스프링 빈 객체의 라이프사이클 ⇒ 객체 생성 → 의존 설정 → 초기화 → 소멸
//                                                  ~~~~~~~~~~~~~~
// org.springframework.beans.factory.InitializingBean 인터페이스의 afterPropertiesSet() 메서드와
// org.springframework.beans.factory.DisposableBean 인터페이스의 destroy() 메서드를 이용

public class Lifecycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifecycleContext.class);

        // 스프링 빈 객체의 라이프사이클 ⇒ 객체 생성 → 의존 설정 → 초기화 → 소멸
        Client client = context.getBean(Client.class);
        client.send();
        System.out.println("before context.close()");
        context.close();
        System.out.println("after context.close()");
        System.out.println();

        // 과거
        // Client oldClient = new Client();
        // 이러한 중간에 넣을 동작을 결정해야 할때 : afterPropertiesSet, destroy등의 메서드를 통해 작용
        // oldClient.setHost("www.test.com");
        // oldClient.send();
        // System.out.println();

        // @Bean 어노테이션의 initMethod 속성과 destroyMethod 속성을 사용해서 초기화 메서드와 소멸 메서드를 지정
        context = new AnnotationConfigApplicationContext(LifecycleContext.class);
        MethodClient methodClient = context.getBean(MethodClient.class);
        methodClient.send();

        System.out.println("before context.close()");
        context.close();
        System.out.println("after context.close()");
    }
}
