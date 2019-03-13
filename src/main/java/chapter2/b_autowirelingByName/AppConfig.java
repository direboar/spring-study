package chapter2.b_autowirelingByName;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import chapter2.b_autowirelingByName.annotation.Lightweight;

@Configuration
@ComponentScan("chapter2.b_autowirelingByName")
public class AppConfig {

	// �����C���^�t�F�[�X�ŕ������̂���ꍇ�B
	// �{�̋L�ڂ̂����Ƃ��ẮA�܂�AppConfig��JavaConfig�ŕʖ��o�^�������������B
	@Bean
	// �J�X�^���E�A�m�e�[�V�����Ŏw�肷�邱�Ƃ��\�B
	@Lightweight
	PasswordEncoder sha256PasswordEncoder() {
		return new Sha256PasswordEncoderImpl();
	}

	// Bean���̓f�t�H���g�ł̓��\�b�h���Bname�����Ŏw�肷�邱�Ƃ��\�B
	@Bean(name = "bcrypt")
	// Primary������ƁA���̂Ńq�b�g���Ȃ������ꍇ�ɗD��I�Ɏg����B
	@Primary
	PasswordEncoder bcryptPasswordEncoder() {
		return new BcryptPasswordEncoderImpl();
	}

}
