package chapter2.f_profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development") // Component��Profile�̕t�^���\�B
public class TransactionForITA implements Transaction {

	@Override
	public boolean start() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

}
