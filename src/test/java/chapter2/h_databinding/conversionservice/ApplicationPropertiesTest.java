package chapter2.h_databinding.conversionservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.h_databinding.conversionservice.customize.EmailValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ApplicationPropertiesTest {

	@Autowired
	private ApplicationProperties testee;

	@Test
	public void testGetDateOfServiceStartingAsString() {
		assertThat(testee.getDateOfServiceStartingAsString()).isEqualTo("17/01/01");
	}

	@Test
	public void testGetDateOfServiceStarting() {
		assertThat(testee.getDateOfServiceStarting()).isEqualTo(LocalDate.of(2017, 1, 1));
	}

	@Test
	public void testGetDateOfServiceStarting_yyyyMMdd() {
		assertThat(testee.getDateOfServiceStarting_yyyyMMdd()).isEqualTo(LocalDate.of(2017, 1, 1));
	}

	@Test
	public void testEmail() {
		assertThat(testee.getEmailValue()).usingRecursiveComparison().isEqualTo(new EmailValue("admin@foo.bar.baz"));
	}

}
