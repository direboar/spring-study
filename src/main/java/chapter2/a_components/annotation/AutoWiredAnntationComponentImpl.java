package chapter2.a_components.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chapter2.a_components.UserRepository;

// アノテーションベースのコンポーネント
// オートワイアリング BY Typeのサンプル。
@Component
public class AutoWiredAnntationComponentImpl implements AnnotationComponent {

	private UserRepository userRepository;

	// フィールド・インジェクション
	@Autowired
	private Hoge hoge;

	private Fuga fuga;

	// コンストラクタ・インジェクション
	@Autowired
	public AutoWiredAnntationComponentImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// セッター・インジェクション
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
