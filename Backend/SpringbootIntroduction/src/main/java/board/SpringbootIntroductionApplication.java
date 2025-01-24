package board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@Slf4j
// 자동 설정
@SpringBootApplication
// @EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class SpringbootIntroductionApplication {

    /* private static Logger log = LoggerFactory.getLogger(SpringbootIntroductionApplication.class); */

    public static void main(String[] args) {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        SpringApplication.run(SpringbootIntroductionApplication.class, args);
    }

}
