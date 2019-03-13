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

	// ����ł��Ȃ��ꍇ�APrimary�Ŏw�肵��Component���C���W�F�N�V���������B
	@Autowired
	private PasswordEncoder defaultEncoder;

	// �A�m�e�[�V�����Ń��C�A�����O�����B
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
