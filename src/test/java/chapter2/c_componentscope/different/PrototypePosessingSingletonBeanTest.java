package chapter2.c_componentscope.different;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.c_componentscope.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class PrototypePosessingSingletonBeanTest {

	@Autowired
	private PrototypePosessingSingletonBean testee;

	@Autowired
	private PrototypePosessingSingletonBean testee2;

	@Test
	public void test() {
		assertThat(testee.count()).isEqualTo(1);
		// PrototypePosessingSingletonBeanが保持するPrototypeBeanは、親のSingletonScopeになるため、戻り値はinclementされる。
		// （PrototypeBeanの状態はクリアされない）
		assertThat(testee2.count()).isEqualTo(2);
	}

}
