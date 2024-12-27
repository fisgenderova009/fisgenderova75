package az.developia.librarian_Fidan_Isgenderova.config.trim;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class JacksonConfig {

	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

		SimpleModule module = new SimpleModule();
		module.addDeserializer(String.class, new TrimStringDeserializer());

		builder.modules(module);
		return builder;
	}
}