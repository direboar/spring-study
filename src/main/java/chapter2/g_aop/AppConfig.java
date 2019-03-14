package chapter2.g_aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("chapter2.g_aop")
@EnableAspectJAutoProxy // AOP�̗L�����ݒ�
public class AppConfig {

}
