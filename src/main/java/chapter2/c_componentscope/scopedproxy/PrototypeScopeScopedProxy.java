package chapter2.c_componentscope.scopedproxy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//ScopedProxyを設定。（Interfaceか実装クラスかで、ScopedProxyModeの設定値を変える。この場合クラスなのでCGLIB適用。）
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeScopeScopedProxy {

	private int counter = 0;

	public int count() {
		return ++counter;
	}

}
