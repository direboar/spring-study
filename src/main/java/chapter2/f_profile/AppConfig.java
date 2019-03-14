package chapter2.f_profile;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ProdConfig.class, DevelopmentConfig.class })
@ComponentScan("chapter2.f_profile")
public class AppConfig {

}
