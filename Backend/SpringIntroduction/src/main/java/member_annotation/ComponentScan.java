package member_annotation;

// 컴포넌트 스캔 ⇒ 스프링이 클래스를 검색해서 빈으로 등록해 주는 기능 ⇒ 설정 클래스에 빈을 등록하지 않아도 원하는 클래스를 빈으로 등록, 사용하는 것이 가능 ⇒ 설정과 관련된 코드가 감소

// @Component ⇒ 해당 클래스를 스캔 대상으로 표시 ⇒ @Component 어노테이션에 값을 설정하지 않으면 클래스 이름의 첫 글자를 소문자로 바꾼 이름을 빈 이름으로 사용

// 기본 스캔 대상
// @Component       Spring이 관리할 모든 일반 컴포넌트에 사용.
// @Controller      HTTP 요청/응답 처리를 담당하는 컨트롤러를 정의.
// @Service         비즈니스 로직을 처리하는 서비스 계층을 정의.
// @Repository      데이터 액세스 계층(DAO)을 정의하며, 예외 변환을 제공.
// @Aspect          AOP를 구현하여 공통 관심사를 모듈화.
// @Configuration   Java 기반으로 Spring 설정 정보를 정의.

public class ComponentScan {
}
