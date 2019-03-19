package chapter3.a_connectionpool;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//テスト用のConfigを追加する。
@ContextConfiguration(classes = { AppConfig.class, TestConfig.class, })
public class JdbcTemplateSampleTest {

	@Autowired
	JdbcTemplateSample testee;

	@Test
	@Transactional // テスト実行時のトランザクション境界をテストメソッドに移動。この場合テスト終了後にロールバックされる。
	@Sql("insert-room.sql") // テスト実施前のSQLを発行する。
	public void testFindRoom() {
		assertThat(testee.findRoom("2")).isNotNull().isEqualTo("room2");
	}

	@Test
	@Transactional // テスト実行時のトランザクション境界をテストメソッドに移動。この場合テスト終了後にロールバックされる。Commitしてほしい時は@Commitを追加で付与する。
	@Sql("insert-room.sql") // テスト実施前のSQLを発行する。
	public void testUpdateRoom() {
		assertThat(testee.updateRoom("hoge", "2")).isEqualTo(1);
		assertThat(testee.findRoom("2")).isNotNull().isEqualTo("hoge");

	}

	@Test
	@Transactional
	@Sql("insert-room.sql") // テスト実施前のSQLを発行する。
	public void testDuplicateKey() {
		assertThat(testee.insertRoom("hoge", "1", 1)).isEqualTo(1);

		// 重複キー例外などは,DataAccessExceptionのサブクラスに変換される。
		// 親はRuntimeExceptionのため、キャッチは任意。
		assertThatThrownBy(() -> {
			testee.insertRoom("hoge", "1", 1);
		}).isInstanceOf(DuplicateKeyException.class).isInstanceOf(DataAccessException.class);
	}

}
