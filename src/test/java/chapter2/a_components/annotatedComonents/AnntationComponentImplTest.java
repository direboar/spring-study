package chapter2.a_components.annotatedComonents;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.a_components.AppConfig;
import chapter2.a_components.annotation.AnnotationComponent;

// Chapter8 SpringTest�̃T���v���B

// AppConfig��L���ɂ��āABean�̃C���W�F�N�V������L���ɂ���B
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AnntationComponentImplTest {

	// �C���W�F�N�V�����ł���B
	@Autowired
	AnnotationComponent testee;

	@Test
	public void test() {
		assertThat(testee.sayHello()).contains("hello,id")
				.contains("hello,Hoge").contains("hello,Fuga");

	}

}
