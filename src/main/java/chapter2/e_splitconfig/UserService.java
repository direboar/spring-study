package chapter2.e_splitconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	@Autowired
	private Repository repository;

	public boolean save() {
		return repository.save();
	}

}
