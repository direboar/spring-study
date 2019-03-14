package chapter2.f_profile;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * �v���t�@�C���̐ݒ�B
 * <p>
 * -Dspring.profiles.active=development�����Ď��s����B ���^�p�̏ڍׂ́Ap56�Q�ƁB
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
