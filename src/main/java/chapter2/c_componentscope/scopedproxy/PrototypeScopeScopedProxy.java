package chapter2.c_componentscope.scopedproxy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//ScopedProxy��ݒ�B�iInterface�������N���X���ŁAScopedProxyMode�̐ݒ�l��ς���B���̏ꍇ�N���X�Ȃ̂�CGLIB�K�p�B�j
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeScopeScopedProxy {

	private int counter = 0;

	public int count() {
		return ++counter;
	}

}
