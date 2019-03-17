package chapter2.a_components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// JavaベースのConfiguration
@Configuration
// コンポーネントスキャンを有効にする
@ComponentScan("chapter2.a_components")
public class AppConfig {

	@Bean
	public UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

}
