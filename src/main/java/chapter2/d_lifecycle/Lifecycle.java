package chapter2.d_lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Lifecycle {

	Logger logger = LoggerFactory.getLogger(Lifecycle.class);

	@PostConstruct
	public void postConstruct() {
		logger.debug("postConstruct");
	}

	public void hello() {
		logger.debug("Hello World");
	}

	@PreDestroy
	public void preDestroy() {
		logger.debug("preDestroy");
	}

}
