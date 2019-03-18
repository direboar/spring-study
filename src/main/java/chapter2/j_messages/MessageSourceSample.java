package chapter2.j_messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceSample {

	@Autowired
	MessageSource messageSource;

	public String getWelcomeMessage() {
		// メッセージコード、埋め込み文字、ロケールを指定。ロケールは必須。
		return messageSource.getMessage("result.succeed", new String[] { "ユーザー登録" }, Locale.JAPANESE);
	}

	public String getUsernameResistrationFinished() {
		// メッセージコード、埋め込み文字、ロケールを指定。ロケールは必須。
		// 埋め込み文字をプロパティ「functionName.userRegistration」で取得して埋め込んでいる。
		return messageSource.getMessage("result.succeed",
				new MessageSourceResolvable[] { new DefaultMessageSourceResolvable("functionName.userRegistration") },
				Locale.JAPANESE);
	}

	public String getWelcomeMessageLocaleEn() {
		// ENロケールのメッセージ取得サンプル。
		return messageSource.getMessage("result.succeed", new String[] { "User Registration " }, Locale.ENGLISH);
	}

}
