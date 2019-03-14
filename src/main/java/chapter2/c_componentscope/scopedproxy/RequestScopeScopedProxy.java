package chapter2.c_componentscope.scopedproxy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//ScopedProxyを設定。（Interfaceか実装クラスかで、ScopedProxyModeの設定値を変える。インタフェースがある場合は、JDKProxyを適用できる。）
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class RequestScopeScopedProxy implements RequestScopeScopedProxyIf {

	private int counter = 0;

	public int count() {
		return ++counter;
	}

}
