package chapter2.g_aop.hello;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {

	public String hello() {
		return "hello";
	}

	public String exception() {
		throw new RuntimeException();
	}

}
