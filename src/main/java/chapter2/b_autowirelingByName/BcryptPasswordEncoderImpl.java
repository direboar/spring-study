package chapter2.b_autowirelingByName;

public class BcryptPasswordEncoderImpl implements PasswordEncoder {

	@Override
	public String encodePassword(String password) {
		return "Bcrypt" + password;
	}

}
