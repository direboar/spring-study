package chapter2.g_aop.others;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(4)
public class WithinInterceptor2 {

	@Before("within(chapter2.g_aop.others.FooService)")
	public void logBeforeServieClass(JoinPoint joinPoint) {
		// Serviceクラスの全メソッドを対象とします。
		System.out.println(String.format("%d logBeforeServieClass : %s", 4, joinPoint.getSignature()));
	}
}
