package chapter2.c_componentscope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // インスタンス取得時に毎回生成される。
public class Prototype {

	private int counter = 0;

	public int count() {
		return ++counter;
	}

}
