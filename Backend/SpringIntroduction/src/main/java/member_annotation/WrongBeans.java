package member_annotation;

// getBean(bean_name, bean_type) 메서드

// 존재하지 않는 빈 이름을 사용했을 때
//
//     private static void processVersionCommand(String[] args) {
//         // VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
//         VersionPrinter versionPrinter = ctx.getBean("notexistent", VersionPrinter.class);
//         versionPrinter.print();
//     }
//
// Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'notexistent' available

// 빈의 실제 타입과 지정한 타입이 다른 경우
//
//     private static void processVersionCommand(String[] args) {
//         // VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
//         // VersionPrinter versionPrinter = ctx.getBean("notexistent", VersionPrinter.class);
//         VersionPrinter versionPrinter = ctx.getBean("versionPrinter", MemberInfoPrinter.class);
//         versionPrinter.print();
//     }
//
// Type mismatch: cannot convert from MemberInfoPrinter to VersionPrinter

// 빈 이름을 지정하지 않고 타입만으로 빈을 구할 수 있음
//
// 해당 타입의 빈 객체가 한 개만 존재하는 경우, 빈 타입만으로 빈을 구할 수 있음
//
//     private static void processVersionCommand(String[] args) {
//         // VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
//         // VersionPrinter versionPrinter = ctx.getBean("notexistent", VersionPrinter.class);
//         // VersionPrinter versionPrinter = ctx.getBean("versionPrinter", MemberInfoPrinter.class);
//         VersionPrinter versionPrinter = ctx.getBean(VersionPrinter.class);
//         versionPrinter.print();
//     }

// 해당 타입의 빈 객체가 존재하지 않는 경우
//
//     private static void processVersionCommand(String[] args) {
//         // VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
//         // VersionPrinter versionPrinter = ctx.getBean("notexistent", VersionPrinter.class);
//         // VersionPrinter versionPrinter = ctx.getBean("versionPrinter", MemberInfoPrinter.class);
//         VersionPrinter versionPrinter = ctx.getBean(NotExistent.class);
//         versionPrinter.print();
//     }
//
//
// NotExistent cannot be resolved to a type

// 같은 타입의 빈 객체가 두 개 이상 존재하는 경우
//
// // AppConf2.java
//
// @Configuration
// public class AppConf2 {
//     @Autowired
//     private MemberDAO memberDAO;
//     @Autowired
//     private MemberPrinter memberPrinter;
//
//     	... (생략) ...
//
//     @Bean
//     public VersionPrinter versionPrinter() {
//         VersionPrinter versionPrinter = new VersionPrinter();
//         versionPrinter.setMajorVersion(5);
//         versionPrinter.setMinorVersion(3);
//         return versionPrinter;
//     }
//
//     @Bean
//     public VersionPrinter newVersionPrinter() {
//         VersionPrinter versionPrinter = new VersionPrinter();
//         versionPrinter.setMajorVersion(6);
//         versionPrinter.setMinorVersion(1);
//         return versionPrinter;
//     }
// }
//
//
// // MainForSpring.java
//
//     private static void processVersionCommand(String[] args) {
//         VersionPrinter versionPrinter = ctx.getBean(VersionPrinter.class);
//         versionPrinter.print();
//     }
//
// Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException:
// No qualifying bean of type 'ex01.VersionPrinter' available: expected single matching bean but found 2: versionPrinter,newVersionPrinter

public class WrongBeans {

}
