package chapter2.f_profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development") // 開発用プロファイル （メソッド単位の指定も可能）
public class DevelopmentConfig {

	@Bean
	Repository repository() {
		return new RepositoryForITA();
	}

}
