package member_next;

import org.springframework.stereotype.Component;

// AppContext.java

// @Configuration
// @ComponentScan(basePackages = { "member_annotation", "member_next" })
// public class AppContext {
//
// WARNING: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanDefinitionStoreException: Failed to parse configuration class [config.AppContext]
// Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'memberRegisterService' for bean class [member_next.MemberRegisterService] conflicts with existing, non-compatible bean definition of same name and class [member_annotation.MemberRegisterService]
//
// @Component
@Component("nextMemberRegisterService") // ⇒ 오류 해결 방법 ⇒ 명시적으로 빈 이름을 설정
public class MemberRegisterService {
}
