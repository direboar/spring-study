package chapter2.c_componentscope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // Scope��t�^���Ȃ��ꍇ�A�f�t�H���g�̓V���O���g���ɂȂ�B
public class Singleton {

	private int count;

	public int count() {
		return ++this.count;
	}

}
