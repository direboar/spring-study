package chapter2.a_components.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chapter2.a_components.UserRepository;

// �A�m�e�[�V�����x�[�X�̃R���|�[�l���g
// �I�[�g���C�A�����O BY Type�̃T���v���B
@Component
public class AutoWiredAnntationComponentImpl implements AnnotationComponent {

	private UserRepository userRepository;

	// �t�B�[���h�E�C���W�F�N�V����
	@Autowired
	private Hoge hoge;

	private Fuga fuga;

	// �R���X�g���N�^�E�C���W�F�N�V����
	@Autowired
	public AutoWiredAnntationComponentImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// �Z�b�^�[�E�C���W�F�N�V����
	@Autowired
	public void setFuga(Fuga fuga) {
		this.fuga = fuga;
	}

	@Override
	public String sayHello() {
		String user = userRepository.select("id");

		StringBuilder builder = new StringBuilder();

		builder.append("hello," + user);
		builder.append("\r\n");
		builder.append("hello," + hoge.sayHello());
		builder.append("\r\n");
		builder.append("hello," + fuga.sayHello());

		return builder.toString();
	}

}
