package chapter3.a_connectionpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
// 伝搬レベル、分離レベルのバリエーション網羅は省略。
public class JdbcTemplateSample {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// トランザクション設定あり
	// デフォルトは伝搬レベル：REQUIRED、分離レベル：DBMS のデフォルトの分離レベル
	// timeoutはアノテーションごとに設定する。
	@Transactional(timeout = 60)
	public int updateRoom(String roomName, String roomId) {
		String sql = "UPDATE room set room_name = ? where room_id = ?";
		return jdbcTemplate.update(sql, roomName, roomId);
	}

	// トランザクションをreadOnlyに設定。
	@Transactional(readOnly = true) // デフォルトは伝搬レベル：REQUIRED、分離レベル：DBMS のデフォルトの分離レベル
	public String findRoom(String roomId) {
		String sql = "SELECT room_name from room where room_id = ?";

		return jdbcTemplate.queryForObject(sql, String.class, roomId);
	}

	@Transactional(timeout = 60)
	public int insertRoom(String roomName, String roomId, int capacity) {
		String sql = "insert into room values (?,?,?)";
		return jdbcTemplate.update(sql, roomName, roomId, capacity);
	}

}
