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

	@Before("execution(* *..*ServiceImpl.*(..))") // �N���X����ServiceImpl�ŏI��邷�ׂĂ�Component���\�b�h�Ăяo���O��PointCut�Ƃ��Ďw��B
	public void startLog(JoinPoint jp) {
		System.out.println("���\�b�h�J�n(@Before)�F" + jp.getSignature());
	}

	// ���O�t���|�C���g�J�b�g�B��`���ė��p����B
	@Pointcut("execution(* *..*ServiceImpl.*(..))")
	public void service() {
	}

	@AfterReturning(value = "service()", returning = "retVal")
	// ��O���������Ȃ��ꍇ�����Ă΂��
	public void endLogAfterReturning(JoinPoint jp, String retVal) {
		System.out.println("���\�b�h�I��(@AfterReturning)�F" + jp.getSignature() + ",�߂�l�F" + retVal);
	}

	@AfterThrowing(value = "service()", throwing = "e")
	// ��O�����������ꍇ�����Ă΂��
	public void errorLog(JoinPoint jp, RuntimeException e) {
		System.out.println("��O����(@AfterThrowing)�F" + jp.getSignature());
		Object target = jp.getTarget(); // Proxy���͂��������̂̃I�u�W�F�N�g������
		Object that = jp.getThis(); // Proxy�iCGILIB�ɂ��j������
		e.printStackTrace();
	}

	@After("service()")
	// ��O���������Ă��Ă΂��
	public void endLogAfter(JoinPoint jp) {
		System.out.println("���\�b�h�I��(@After)�F" + jp.getSignature());
	}

	@Around("service()")
	public Object logAround(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("���\�b�h�J�n(@Around)�F" + jp.getSignature());
		try {
			Object retVal = jp.proceed();
			System.out.println("���\�b�h�I��(@Around)�F" + jp.getSignature());
			return retVal;
		} catch (Throwable e) {
			System.out.println("��O����(@Around)�F" + jp.getSignature());
			e.printStackTrace(System.out);
			throw e;
		}
	}

}
