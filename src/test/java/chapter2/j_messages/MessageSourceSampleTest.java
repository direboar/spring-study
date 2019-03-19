package chapter2.j_messages;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

public class MessageSourceSampleTest {

	@Autowired
	private MessageSourceSample testee;

	@Test
	public void testGetWelcomeMessage() {
		assertThat(testee.getWelcomeMessage()).isEqualTo("ユーザー登録処理が終了しました。");
	}

	@Test
	public void testGetWelcomeMessageLocaleEn() {
		assertThat(testee.getWelcomeMessageLocaleEn()).isEqualTo("User Registration Operation Finished.");
	}

	@Test
	public void testGetUsernameResistrationFinished() {
		assertThat(testee.getUsernameResistrationFinished()).isEqualTo("ユーザー登録処理が終了しました。");
	}

}
