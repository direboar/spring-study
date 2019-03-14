package chapter2.g_aop.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.g_aop.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
//メソッド開始：void chapter2.g_aop.hello.UserServiceImpl.hello() と出力される。
public class UserServiceImplTest {

	@Autowired
	private UserServiceImpl testee;

	@Test
	public void testHello() {
		testee.hello();
	}

	@Test
	public void testException() {
		testee.exception();
	}

}
