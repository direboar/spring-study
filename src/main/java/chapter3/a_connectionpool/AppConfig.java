package chapter3.a_connectionpool;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("chapter3.a_connectionpool")
@EnableTransactionManagement // 宣言的トランザクションを有効にする。
public class AppConfig {

	/**
	 * JDBCTemplateをBean登録する。
	 * 
	 * @return JDBCTemplate
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

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

	/**
	 * PlatformTransactionManagerをBean登録する。
	 * 
	 * @return PlatformTransactionManager
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

}
