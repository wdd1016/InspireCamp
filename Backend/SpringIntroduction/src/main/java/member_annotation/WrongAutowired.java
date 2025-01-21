package member_annotation;

// @Autowired 어노테이션
// 사용 객체에서 의존 객체 필드에 @Autowired 어노테이션을 붙이면 스프링이 자동으로 해당 타입의 빈 객체를 찾아서 필드에 할당
// @Autowired 어노테이션을 setter 메서드에 붙이면, 스프링이 해당 setter 메서드를 통해 의존성을 주입

// 일치하는 빈이 없는 경우
//
// // MemberListPrinter.java
//
// public class MemberListPrinter {
//     @Autowired
//     private MemberDAO memberDAO;
//
//     @Autowired
//     private MemberPrinter printer;
//
// //    public MemberListPrinter(MemberDAO memberDAO, MemberPrinter printer) {
// //        this.memberDAO = memberDAO;
// //        this.printer = printer;
// //    }
//
//     public void printAll() {
//         Collection<Member> members = memberDAO.selectAll();
//         members.forEach(member -> printer.print(member));
//     }
// }
//
// // AppCtx.java
//
//     @Bean
//     public MemberListPrinter memberListPrinter() {
//         // return new MemberListPrinter(memberDAO(), memberPrinter());
//         return new MemberListPrinter();		⇐ 의존객체를 매개변수로 가지는 생성자가 삭제되었기
//     }						     	   때문에 기본 생성자로 변경
//
//
//     // @Bean						⇐ MemberListPrinter에서 @Autowired 대상 객체를
//     public MemberDAO memberDAO() {			   빈으로 등록하지 않음
//         return new MemberDAO();
//     }
//
// 경고: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'changePwdSvc': Unsatisfied dependency expressed through field 'memberDAO'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'ex01.MemberDAO' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
// Exception in thread "main" org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'changePwdSvc': Unsatisfied dependency expressed through field 'memberDAO'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'ex01.MemberDAO' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}


// 일치하는 빈이 두 개 이상인 경우
//
//
// AppCtx.java
//
// @Bean
// public MemberDAO memberDAO() { return new MemberDAO(); }
//
// @Bean
// public MemberPrinter memberPrinter() { return new MemberPrinter(); }
//
// @Bean
// public MemberPrinter memberPrinter2() { return new MemberPrinter(); }
//
// MemberListPrinter.java
// public class MemberListPrinter {
//     @Autowired
//     private MemberDAO memberDAO;
//
//     @Autowired
//     private MemberPrinter printer;
//
// //    public MemberListPrinter(MemberDAO memberDAO, MemberPrinter printer) {
// //        this.memberDAO = memberDAO;
// //        this.printer = printer;
// //    }
//
//     public void printAll() {
//         Collection<Member> members = memberDAO.selectAll();
//         members.forEach(member -> printer.print(member));
//     }
// }
//
// 경고: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'memberListPrinter': Unsatisfied dependency expressed through field 'printer'; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'ex01.MemberPrinter' available: expected single matching bean but found 2: memberPrinter2,memberPrinter
// Exception in thread "main" org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'memberListPrinter': Unsatisfied dependency expressed through field 'printer'; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'ex01.MemberPrinter' available: expected single matching bean but found 2: memberPrinter2,memberPrinter


public class WrongAutowired {
}
