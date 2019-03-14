package chapter2.c_componentscope.scopedproxy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//ScopedProxy��ݒ�B�iInterface�������N���X���ŁAScopedProxyMode�̐ݒ�l��ς���B�C���^�t�F�[�X������ꍇ�́AJDKProxy��K�p�ł���B�j
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class RequestScopeScopedProxy implements RequestScopeScopedProxyIf {

	private int counter = 0;

	public int count() {
		return ++counter;
	}

}
