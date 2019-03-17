package chapter2.h_databinding.conversionservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

import chapter2.h_databinding.conversionservice.customize.StringToEmailValueConverter;

@Configuration
@ComponentScan("chapter2.h_databinding.conversionservice")

//プロパティファイルの読み込み宣言
//@PropertySource("classpath:chapter2/h_databinding/conversionservice/application.properties")
//複数プロパティを指定した場合は、指定した順に読みこむ。（あと勝ち）
@PropertySource(value = { "classpath:chapter2/h_databinding/conversionservice/application.properties",
		"classpath:chapter2/h_databinding/conversionservice/application2.properties" })
public class AppConfig {

	// 型変換用のサービス。
	@Bean
	public ConversionService conversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		// カスタマイズで開発したコンバータを追加する。
		conversionService.addConverter(new StringToEmailValueConverter());
		return conversionService;
	}

	// プロパティを@Valueにインジェクションできるようにするサービス。
	// これがないとプロパティへのインジェクションができないので注意！！
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
