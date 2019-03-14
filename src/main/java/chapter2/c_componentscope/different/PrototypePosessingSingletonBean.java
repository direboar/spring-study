package chapter2.c_componentscope.different;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chapter2.c_componentscope.Prototype;

@Component
//prototype�X�R�[�v��ێ����Ă���SingletonBean
public class PrototypePosessingSingletonBean {

	@Autowired
	private Prototype prototype;

	public int count() {
		return prototype.count();
	}

}
