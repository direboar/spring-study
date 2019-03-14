package chapter2.e_splitconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

	@Bean
	UserService userService() {
		return new UserService();
	}

}
