package chapter2.h_databinding.conversionservice.customize;

import org.springframework.core.convert.converter.Converter;

public class StringToEmailValueConverter implements Converter<String, EmailValue> {

	@Override
	public EmailValue convert(String source) {
		return new EmailValue(source);
	}

}
