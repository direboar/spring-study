package chapter2.b_autowirelingByName;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import chapter2.b_autowirelingByName.annotation.Lightweight;

@Configuration
@ComponentScan("chapter2.b_autowirelingByName")
public class AppConfig {

	// 同じインタフェースで複数名称ある場合。
	// 本の記載のやり方としては、まずAppConfigにJavaConfigで別名登録するやり方がある。
	@Bean
	// カスタム・アノテーションで指定することも可能。
	@Lightweight
	PasswordEncoder sha256PasswordEncoder() {
		return new Sha256PasswordEncoderImpl();
	}

	// Bean名はデフォルトではメソッド名。name属性で指定することも可能。
	@Bean(name = "bcrypt")
	// Primaryをつけると、名称でヒットしなかった場合に優先的に使われる。
	@Primary
	PasswordEncoder bcryptPasswordEncoder() {
		return new BcryptPasswordEncoderImpl();
	}

}
