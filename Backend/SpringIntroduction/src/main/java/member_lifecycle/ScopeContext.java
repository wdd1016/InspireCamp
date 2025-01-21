package member_lifecycle;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeContext {
    @Bean(initMethod = "connect", destroyMethod = "close")
    @org.springframework.context.annotation.Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MethodClient methodClient() {
        MethodClient client = new MethodClient();
        client.setHost("www.test.com");
        return client;
    }

    @Bean(initMethod = "connect", destroyMethod = "close")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeClient methodAnotherClient() {
        PrototypeClient client = new PrototypeClient();
        client.setHost("www.test.com");
        return client;
    }
}
