package chapter2.f_profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod") // Component��Profile�̕t�^���\�B
public class TransactionImpl implements Transaction {

	@Override
	public boolean start() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return true;
	}

}
