package chapter2.h_databinding.conversionservice;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import chapter2.h_databinding.conversionservice.customize.EmailValue;

@Component
public class ApplicationProperties {

	// Stringのままプロパティを読み込む
	// ここでは割愛するが、プロパティはプロパティ以外にシステムプロパティ、環境変数から読み込むことも可能
	// (システムプロパティ→環境変数→プロパティファイルの優先順位）
	@Value("${dateOfServiceStating}")
	private String dateOfServiceStartingAsString;

	// Stringがlocaldateに自動で型変換される。
	@Value("${dateOfServiceStating}")
	private LocalDate dateOfServiceStarting;

	// フォーマットを指定した場合。
	@Value("${dateOfServiceStating_yyyyMMdd}")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate dateOfServiceStarting_yyyyMMdd;

	// カスタマイズで追加開発した型変換を試す。
	@Value("${email}")
	private EmailValue emailValue;

	public String getDateOfServiceStartingAsString() {
		return dateOfServiceStartingAsString;
	}

	public LocalDate getDateOfServiceStarting() {
		return dateOfServiceStarting;
	}

	public LocalDate getDateOfServiceStarting_yyyyMMdd() {
		return dateOfServiceStarting_yyyyMMdd;
	}

	public EmailValue getEmailValue() {
		return emailValue;
	}

}
