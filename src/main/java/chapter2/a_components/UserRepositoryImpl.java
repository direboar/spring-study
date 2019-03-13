package chapter2.a_components;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public String select(String id) {
		return id;
	}

}
