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

//request,sessionスコープのテストをJUnitで行う場合に、設定必要。
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
		assertThat(testee.delegetePrototypeScopeScopedProxy()).isEqualTo(1); // prototypeのproxyは呼び出し都度インスタンスが別になるため。
	}

	@Test
	public void testDelegeteRequestScopeScopedProxy() {
		assertThat(testee.delegeteRequestScopeScopedProxy()).isEqualTo(1);
		assertThat(testee.delegeteRequestScopeScopedProxy()).isEqualTo(2); // requestスコープのproxyはリクエスト単位となるため
		assertThat(testee2.delegeteRequestScopeScopedProxy()).isEqualTo(3); // proxyを保持するComponentのスコープには依存しないため
	}

}
