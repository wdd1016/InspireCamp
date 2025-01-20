package ex01_member.config;

// 스프링은 런타임에 설정 클래스를 상속한 새로운 설정 클래스를 만들어서 사용 ⇒ 싱글톤 스코프를 제공

// [의사코드]
// @Configuration
// public class AppCtx {
//     @Bean
//     public MemberDAO memberDAO() {
//         return new MemberDAO();
//     }
// 	... (생략) ...
// }
//
// public class AppCtxExt extends AppCtx {
//     private Map<String, Object> beans = ... ;
//
//     @Override
//     public MemberDAO memberDAO() {
//         if (!beans.containsKey("memberDAO")) {
//             beans.put("memberDAO", super.memberDAO());
//         }
//         return (MemberDAO) beans.get("memberDAO");
//     }
//
// }

public class SudoAppContext {
}
