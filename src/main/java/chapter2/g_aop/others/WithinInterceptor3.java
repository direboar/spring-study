package chapter2.g_aop.others;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(5)
public class WithinInterceptor3 {

	@Before("within(chapter2.g_aop.others.Hoge+)")
	public void logBeforeHogeImplementClass(JoinPoint joinPoint) {
		// Hogeを実装した全メソッドを対象とします。
		System.out.println(String.format("%d logBeforeServieClassAndSubPackages : %s", 5, joinPoint.getSignature()));
	}

}
