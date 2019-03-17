package chapter2.g_aop.others;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.g_aop.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class WithinInterceptorTest {

	@Autowired
	private FooService service;

	@Autowired
	private Hoge hoge;

	@Test
	public void testHoge() {
		hoge.hoge();
	}

	@Test
	public void testService() {
		service.hello();
	}

}
