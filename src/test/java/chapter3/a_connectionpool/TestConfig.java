package chapter3.a_connectionpool;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class TestConfig {

	// テスト用にH2のDataSourceを追加するサンプル。
	// この例では、mainのソースもH2を見ているので不要だが、あくまでサンプル、ノウハウのコードとして記載する。
	/**
	 * H2のDataSourceをBean登録する。
	 * 
	 * @return H2のDataSource
	 */
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.setScriptEncoding("UTF-8") // SQLファイルのエンコーディング
			.addScripts("META-INF/sql/schema.sql", "META-INF/sql/insert-init-data.sql") // DDL、DML
			.build();
	}

}
