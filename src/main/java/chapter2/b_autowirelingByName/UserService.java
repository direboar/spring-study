package chapter2.b_autowirelingByName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import chapter2.b_autowirelingByName.annotation.Lightweight;

@Component
public class UserService {

	@Autowired
	@Qualifier("sha256PasswordEncoder")
	private PasswordEncoder passwordEncoder;

	// 特定できない場合、Primaryで指定したComponentがインジェクションされる。
	@Autowired
	private PasswordEncoder defaultEncoder;

	// アノテーションでワイアリングする例。
	@Autowired
	@Lightweight
	private PasswordEncoder lightweightEncoder;

	public String regist(String password) {
		return passwordEncoder.encodePassword(password);
	}

	public String registByDefaultEncoder(String password) {
		return defaultEncoder.encodePassword(password);
	}

	public String registByLightweight(String password) {
		return lightweightEncoder.encodePassword(password);
	}

}
