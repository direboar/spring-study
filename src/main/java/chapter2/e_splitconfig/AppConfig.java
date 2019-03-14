package chapter2.e_splitconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DomainConfig.class, InfratoructureConfig.class })
public class AppConfig {

}
