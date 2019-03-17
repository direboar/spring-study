package chapter2.g_aop.others;

import org.springframework.stereotype.Component;

@Component
public class HogeImpl implements Hoge {

	@Override
	@Intercepted
	public void hoge() {
	}

}
