package chapter2.c_componentscope.scopedproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProxyInjectedSingleton {

	// prototype��proxy��ݒ肵���ꍇ�A�����I�ɕێ����Ă���̂�Proxy�Ȃ̂Łi���Ǝv���j�A
	// �Ăяo���s�x�ʃC���X�^���X�ɂȂ�B����͎g���Â炢�����ŁASpring��
	// proxy�̐ݒ��request,session,globalsession�ɑ΂���K�p�𐄏����Ă���B
	@Autowired
	private PrototypeScopeScopedProxy prototypeScopeScopedProxy;

	// RequestScope��Proxy�B�V���O���g���ɃC���W�F�N�V�������Ă��A���Ȃ����N�G�X�g�P�ʂɈ�����B
	@Autowired
	private RequestScopeScopedProxyIf requestScopeScopedProxy;

	public int delegetePrototypeScopeScopedProxy() {
		return this.prototypeScopeScopedProxy.count();
	}

	public int delegeteRequestScopeScopedProxy() {
		return this.requestScopeScopedProxy.count();
	}

}
