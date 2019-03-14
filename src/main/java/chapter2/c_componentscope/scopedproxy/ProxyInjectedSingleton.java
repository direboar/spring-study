package chapter2.c_componentscope.scopedproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProxyInjectedSingleton {

	// prototypeにproxyを設定した場合、内部的に保持しているのがProxyなので（だと思う）、
	// 呼び出し都度別インスタンスになる。これは使いづらい挙動で、Springは
	// proxyの設定はrequest,session,globalsessionに対する適用を推奨している。
	@Autowired
	private PrototypeScopeScopedProxy prototypeScopeScopedProxy;

	@Autowired
	private RequestScopeScopedProxyIf requestScopeScopedProxy;

	public int delegetePrototypeScopeScopedProxy() {
		return this.prototypeScopeScopedProxy.count();
	}

	public int delegeteRequestScopeScopedProxy() {
		return this.requestScopeScopedProxy.count();
	}

}
