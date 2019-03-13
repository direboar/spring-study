package chapter2.b_autowirelingByName;

import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordEncoderImpl implements PasswordEncoder {

	@Override
	public String encodePassword(String password) {
		return "Bcrypt" + password;
	}

}
