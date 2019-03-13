package chapter2.a_components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Java�x�[�X��Configuration
@Configuration
// �R���|�[�l���g�X�L������L���ɂ���
@ComponentScan("chapter2.a_components")
public class AppConfig {

	@Bean
	public UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

}
