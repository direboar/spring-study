package chapter2.g_aop.others;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class OtherInterceptor2 {

	// 末尾がServiceで終わるComponentにPointCutする
	@After("bean(*Service)")
	public void doAfterAllBeanEndsWithService(JoinPoint joinPoint) {
		System.out.println(String.format("%d doAfterAllBeanEndsWithService : %s", 2, joinPoint.getSignature()));
	}

}
