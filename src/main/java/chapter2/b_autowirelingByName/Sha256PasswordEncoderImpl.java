package chapter2.b_autowirelingByName;

public class Sha256PasswordEncoderImpl implements PasswordEncoder {

	@Override
	public String encodePassword(String password) {
		return "SHA" + password;
	}

}
