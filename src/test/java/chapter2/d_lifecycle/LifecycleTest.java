package chapter2.d_lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class LifecycleTest {

	@Autowired
	private Lifecycle testee;

// FIXME jMockit configuration.

//	@Mocked
//	private Logger logger;
//
	@Test
	public void test() {
//		new Expectations() {
//			{
//				logger.debug("postConstruct");
//				logger.debug("preDestroy");
//			}
//		};
//
		testee.hello();
	}

}
