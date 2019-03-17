package chapter2.g_aop.others;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
// インターセプタの順序は、@Orderedもしくは@Priorityで指定。
// なお、同じアドバイスに定義したアスペクトが、同じ女陰ポイントに複数ヒットした場合の順番は不定になる。
//そのため、アスペクトはクラス単位で定義したほうが無難。
// かなりハマったので気を付けよう…。

//https://docs.spring.io/spring/docs/5.2.0.BUILD-SNAPSHOT/spring-framework-reference/core.html#aop-ataspectj-advice-ordering
public class OtherInterceptor {

	// @Interceptedを条件にPointCut
	@After("@annotation(chapter2.g_aop.others.Intercepted)")
	public void doAfterInterceptedAnnotation(JoinPoint joinPoint) {
		System.out.println(String.format("%d doAfterInterceptedAnnotation: %s", 1, joinPoint.getSignature()));
	}

}
