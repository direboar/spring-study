package chapter2.c_componentscope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // Scopeを付与しない場合、デフォルトはシングルトンになる。
public class Singleton {

	private int count;

	public int count() {
		return ++this.count;
	}

}
