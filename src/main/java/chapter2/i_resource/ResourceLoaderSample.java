package chapter2.i_resource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

@Component
public class ResourceLoaderSample {

	@Autowired
	ResourceLoader resourceLoader;

	// @Valueを使うことで、リソースを直接インジェクションする。
	@Value("${google.site:http://www.google.co.jp}") // プロパティにgoogle.siteが設定されていればそれを、設定なしの場合はデフォルトを使用する。
	Resource googlePageResource;

	// Ant形式のマッチングを使うことで、複数マッチングできる。
	@Autowired
	ResourcePatternResolver resourcePatternResolver;

	public String loadYahooPage() {
		// ResourceLoaderに対して、httpプロトコルでリソースを取得。
		Resource resource = resourceLoader.getResource("http://www.yahoo.co.jp");
		return this.readStream(resource);
	}

	public Stream<String> loadAllPropertyFileByClasspath() {
		// ResourceLoaderに対して、classpath起点でリソースを取得。
		// 条件に合致するプロパティを全部取得。
		try {
			Resource[] resources = resourcePatternResolver.getResources("classpath*:**/application*.properties");
			return Arrays.asList(resources).stream().map(this::readStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String loadPropertyFileByClasspath() {
		// ResourceLoaderに対して、classpath起点でリソースを取得。
		Resource resource = resourceLoader
				.getResource("classpath:chapter2/h_databinding/conversionservice/application2.properties");
		return this.readStream(resource);
	}

	public String loadGooglePage() {
		return this.readStream(googlePageResource);
	}

	private String readStream(Resource resource) {
		try {
			try (InputStream is = resource.getInputStream()) {
				String content = StreamUtils.copyToString(is, StandardCharsets.UTF_8);
				return content;
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
