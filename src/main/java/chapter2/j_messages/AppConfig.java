package chapter2.j_messages;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan("chapter2.j_messages")

public class AppConfig {

	// MessageSourceの登録
	@Bean
	// bean IDはmessageSourceとすることで自動検出される。
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames("messages"); // プロパティファイル名

//		resourceBundleMessageSource.setBasenames("native"); // プロパティファイル名
//		resourceBundleMessageSource.setDefaultEncoding("UTF-8");// ネイティブコードのプロパティを使う場合の設定。

		return resourceBundleMessageSource;
	}

}
