package chapter2.g_aop.others;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class WithinInterceptor {

	// 型で定義
	@Before("within(chapter2.g_aop..*)")
	public void logBeforeServieClassAndSubPackages(JoinPoint joinPoint) {
		// 指定したパッケージとそのサブパッケージにインターセプトします。
		// この場合、ServiceとHogeにインターセプトされます。
		System.out.println(String.format("%d logBeforeServieClassAndSubPackages : %s", 3, joinPoint.getSignature()));
	}

}
