package chapter2.c_componentscope.different;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chapter2.c_componentscope.Prototype;

@Component
//prototypeスコープを保持しているSingletonBean。
public class PrototypePosessingSingletonBean {

	@Autowired
	// PrototypeはProxyではないので、PrototypePosessingSingletonBeanのライフサイクルと一致する。
	private Prototype prototype;

	public int count() {
		return prototype.count();
	}

}
