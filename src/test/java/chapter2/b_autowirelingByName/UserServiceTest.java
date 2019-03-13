package chapter2.b_autowirelingByName;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceTest {

	@Autowired
	UserService testee;

	@Test
	public void testRegist() {
		assertThat(testee.regist("password")).isEqualTo("SHApassword");
	}

	@Test
	public void testRegistByDefaultEncoder() {
		assertThat(testee.registByDefaultEncoder("password"))
				.isEqualTo("Bcryptpassword");
	}

	@Test
	public void testRegistByLightweight() {
		assertThat(testee.registByLightweight("password"))
				.isEqualTo("SHApassword");
	}

	@Test
	public void testRegistByList() {
		assertThat(testee.registByList("password")).contains("SHApassword")
				.contains("Bcryptpassword");

	}

	@Test
	public void testRegistByMap() {
		assertThat(testee.registByMap("password")).contains("SHApassword")
				.contains("Bcryptpassword");

	}
}
