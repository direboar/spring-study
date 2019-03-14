package chapter2.g_aop.hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodStartLoggingAspect {

	@Before("execution(* *..*ServiceImpl.*(..))") // クラス名がServiceImplで終わるすべてのComponentメソッド呼び出し前をPointCutとして指定。
	public void startLog(JoinPoint jp) {
		System.out.println("メソッド開始(@Before)：" + jp.getSignature());
	}

	// 名前付きポイントカット。定義を再利用する。
	@Pointcut("execution(* *..*ServiceImpl.*(..))")
	public void service() {
	}

	@AfterReturning(value = "service()", returning = "retVal")
	// 例外が発生しない場合だけ呼ばれる
	public void endLogAfterReturning(JoinPoint jp, String retVal) {
		System.out.println("メソッド終了(@AfterReturning)：" + jp.getSignature() + ",戻り値：" + retVal);
	}

	@AfterThrowing(value = "service()", throwing = "e")
	// 例外が発生した場合だけ呼ばれる
	public void errorLog(JoinPoint jp, RuntimeException e) {
		System.out.println("例外発生(@AfterThrowing)：" + jp.getSignature());
		Object target = jp.getTarget(); // Proxyをはがした実体のオブジェクトが取れる
		Object that = jp.getThis(); // Proxy（CGILIBによる）が取れる
		e.printStackTrace();
	}

	@After("service()")
	// 例外が発生しても呼ばれる
	public void endLogAfter(JoinPoint jp) {
		System.out.println("メソッド終了(@After)：" + jp.getSignature());
	}

	@Around("service()")
	public Object logAround(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("メソッド開始(@Around)：" + jp.getSignature());
		try {
			Object retVal = jp.proceed();
			System.out.println("メソッド終了(@Around)：" + jp.getSignature());
			return retVal;
		} catch (Throwable e) {
			System.out.println("例外発生(@Around)：" + jp.getSignature());
			e.printStackTrace(System.out);
			throw e;
		}
	}

}
