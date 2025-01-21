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
