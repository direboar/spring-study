package chapter2.c_componentscope.scopedproxy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import chapter2.c_componentscope.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)

//request,session�X�R�[�v�̃e�X�g��JUnit�ōs���ꍇ�ɁA�ݒ�K�v�B
//@see https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/testing.html#testcontext-web-scoped-beans
@WebAppConfiguration
public class ProxyInjectedSingletonTest {

	@Autowired
	private ProxyInjectedSingleton testee;

	@Autowired
	private ProxyInjectedSingleton testee2;

	@Test
	public void testDelegetePrototypeScopeScopedProxy() {
		assertThat(testee.delegetePrototypeScopeScopedProxy()).isEqualTo(1);
		assertThat(testee.delegetePrototypeScopeScopedProxy()).isEqualTo(1); // prototype��proxy�͌Ăяo���s�x�C���X�^���X���ʂɂȂ邽�߁B
	}

	@Test
	public void testDelegeteRequestScopeScopedProxy() {
		assertThat(testee.delegeteRequestScopeScopedProxy()).isEqualTo(1);
		assertThat(testee.delegeteRequestScopeScopedProxy()).isEqualTo(2); // request�X�R�[�v��proxy�̓��N�G�X�g�P�ʂƂȂ邽��
		assertThat(testee2.delegeteRequestScopeScopedProxy()).isEqualTo(3); // proxy��ێ�����Component�̃X�R�[�v�ɂ͈ˑ����Ȃ�����
	}

}
