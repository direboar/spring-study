package chapter2.c_componentscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Service {

	@Autowired // Prototypeなので、Serviceのインスタンスごとに別インスタンス。
	private Prototype prototype;

	@Autowired
	private Singleton singleton;

	public int hello() {
		return prototype.count() + singleton.count();
	}

}
