package member_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleContext {
    @Bean
    public Client client() {
        Client client = new Client();
        client.setHost("www.test.com");
        return client;
    }

    @Bean(initMethod = "connect", destroyMethod = "close")
    public MethodClient methodClient() {
        MethodClient client = new MethodClient();
        client.setHost("www.test.com");
        return client;
    }
}
