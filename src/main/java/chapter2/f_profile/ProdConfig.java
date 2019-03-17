package chapter2.f_profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod") // プロダクション用プロファイル
public class ProdConfig {

	@Bean
	Repository repository() {
		return new RepositoryImpl();
	}

}
