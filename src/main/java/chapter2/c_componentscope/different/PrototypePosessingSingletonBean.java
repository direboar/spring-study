package chapter2.c_componentscope.different;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chapter2.c_componentscope.Prototype;

@Component
//prototype�X�R�[�v��ێ����Ă���SingletonBean�B
public class PrototypePosessingSingletonBean {

	@Autowired
	// Prototype��Proxy�ł͂Ȃ��̂ŁAPrototypePosessingSingletonBean�̃��C�t�T�C�N���ƈ�v����B
	private Prototype prototype;

	public int count() {
		return prototype.count();
	}

}
