package chapter2.f_profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development") // �J���p�v���t�@�C�� �i���\�b�h�P�ʂ̎w����\�j
public class DevelopmentConfig {

	@Bean
	Repository repository() {
		return new RepositoryForITA();
	}

}
