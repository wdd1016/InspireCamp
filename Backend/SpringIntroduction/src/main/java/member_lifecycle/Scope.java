package member_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 싱글톤 범위
// 별도로 스코프를 지정하지 않으면 기본적으로 싱글톤 스코프가 적용
// @Scope("singleton") 또는 @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) 어노테이션을 사용해서 명시적으로 지정
//
// AppContext.java
// @Configuration
// @ComponentScan(basePackages = { "ex01", "ex02" })
// public class AppContext {
// @Bean(initMethod = "connect", destroyMethod = "close")
// @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
// public Client Client() {
//     Client client = new Client();
//     client.setHost("www.test.com");
//     return client;
// }

// 프로토타입 범위
//
// 새로운 인스터스가 요청될 때마다 생성되는 범위
// @Scope("prototype") 또는 @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) 어노테이션을 사용
//
// AppContext.java
// @Configuration
// @ComponentScan(basePackages = { "ex01", "ex02" })
// public class AppContext {
// @Bean(initMethod = "connect", destroyMethod = "close")
// @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// public MethodClient methodClient() {
//     MethodClient client = new MethodClient();
//     client.setHost("www.test.com");
//     return client;
// }

public class Scope {
    public static void main(String[] args) {
        // Singleton Scope
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeContext.class);
        MethodClient c1 = context.getBean(MethodClient.class);
        MethodClient c2 = context.getBean(MethodClient.class);

        System.out.println();
        System.out.println("Singleton Scope");
        System.out.println("c1 == c2 : " + (c1 == c2)); // true
        context.close();
        System.out.println();

        // Prototype Scope
        context = new AnnotationConfigApplicationContext(ScopeContext.class);
        PrototypeClient c3 = context.getBean(PrototypeClient.class);
        PrototypeClient c4 = context.getBean(PrototypeClient.class);

        System.out.println();
        System.out.println("Prototype Scope");
        System.out.println("c3 == c4 : " + (c3 == c4)); // true
        context.close();
    }
}
