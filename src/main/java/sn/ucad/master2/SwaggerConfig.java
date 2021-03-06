package sn.ucad.master2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/dec.*"), regex("/ws_*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Declaration Impot API")
				.description("Declaration Impot API reference for developers")
				.termsOfServiceUrl("http://localhost.com")
				.contact("diamasta@gmail.com").license("MastaFlex")
				.licenseUrl("diamasta@gmail.com").version("1.0").build();
	}

	// swagger UI URL: http://localhost:8080/swagger-ui.html
	
}