package chapter2.a_components.annotation;

import org.springframework.stereotype.Component;

@Component
public class HogeImpl implements Hoge {

	public String sayHello() {
		return "Hoge";
	}

}
