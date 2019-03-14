package chapter2.f_profile;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * プロファイルの設定。
 * <p>
 * -Dspring.profiles.active=developmentをつけて実行する。 実運用の詳細は、p56参照。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)

public class RepositoryTest {

	@Autowired
	private Repository testee;

	@Autowired
	private Transaction transaction;

	@Test
	public void test() {
		assertThat(testee.save()).isFalse();
		assertThat(transaction.start()).isFalse();
	}

}
