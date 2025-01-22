package aspect;

import calculator.Calculator;
import calculator.ImpCalculator;
import calculator.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectContext {
    // Advice의 적용 순서는 설정 클래스에 빈 순서와 동일하게 동작 ⇒ 스프링 프레임워크와 자바 버전에 따라 상이
    @Bean
    public CacheAspect cacheAspect() {
        return new CacheAspect();
    }

    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator recCalculator() {
        return new RecCalculator();
    }

    @Bean
    public Calculator impCalculator() {
        return new ImpCalculator();
    }
}
