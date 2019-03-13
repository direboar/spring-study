package chapter2.b_autowirelingByName;

import java.util.List;
import java.util.Map;

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

	// コレクションにまとめてインジェクション。
	// debugメモ：こうした場合、実際にはPasswordEncoderには３つのBeanが登録される。
	@Autowired
	private List<PasswordEncoder> allEncoderList;
	@Autowired
	private Map<String, PasswordEncoder> allEncoderMap;

	public String regist(String password) {
		return passwordEncoder.encodePassword(password);
	}

	public String registByDefaultEncoder(String password) {
		return defaultEncoder.encodePassword(password);
	}

	public String registByLightweight(String password) {
		return lightweightEncoder.encodePassword(password);
	}

	public String registByList(String password) {
		StringBuilder builder = new StringBuilder();
		for (PasswordEncoder passwordEncoder : allEncoderList) {
			builder.append(passwordEncoder.encodePassword(password));
		}
		return builder.toString();
	}

	public String registByMap(String password) {
		StringBuilder builder = new StringBuilder();

		builder.append(allEncoderMap.get("sha256PasswordEncoder")
				.encodePassword(password));
		builder.append(allEncoderMap.get("bcrypt").encodePassword(password));

		return builder.toString();
	}

}
