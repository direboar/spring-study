package chapter2.a_components;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter2.a_components.annotation.AnnotationComponent;

public class Main {

	public static void main(String args[]) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		try {
			AnnotationComponent annotationComponent = context
					.getBean(AnnotationComponent.class);
			annotationComponent.sayHello();
		} finally {
			context.close();
		}
	}
}
