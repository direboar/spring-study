package chapter2.i_resource;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ResourceLoaderSampleTest {

	@Autowired
	private ResourceLoaderSample testee;

	@Test
	public void testLoadYahooPage() {
		assertThat(testee
			.loadYahooPage())
				.isNotNull();
	}

	@Test
	public void testLoadPropertyFileByClasspath() {
		assertThat(testee
			.loadPropertyFileByClasspath())
				.isNotNull();
	}

	@Test
	public void testLoadGooglePage() {
		assertThat(testee
			.loadGooglePage())
				.isNotNull();
	}

	@Test
	public void testLoadAllPropertyFileByClasspath() {
		assertThat(testee
			.loadAllPropertyFileByClasspath())
				.hasSize(2);

	}
}
