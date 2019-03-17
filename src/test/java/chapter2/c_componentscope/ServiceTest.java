package chapter2.c_componentscope;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ServiceTest {

	@Autowired
	private Service service;

	// ServiceはPrototypeスコープなので、別インスタンスになる。
	@Autowired
	private Service service2;

	@Test
	public void test() {
		assertThat(service.hello()).isEqualTo(2);
		// Singletonはインスタンスが同じ。Prototypeはインスタンス取得毎に別生成されるためこうなるはず
		assertThat(service2.hello()).isEqualTo(3);

	}

}
