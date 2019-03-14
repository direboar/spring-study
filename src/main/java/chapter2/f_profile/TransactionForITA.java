package chapter2.f_profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development") // ComponentにProfileの付与も可能。
public class TransactionForITA implements Transaction {

	@Override
	public boolean start() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
