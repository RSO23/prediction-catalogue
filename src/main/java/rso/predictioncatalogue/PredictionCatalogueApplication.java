package rso.predictioncatalogue;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
@EnableSwagger2
@EnableDiscoveryClient
public class PredictionCatalogueApplication {

	private static final Logger log = LoggerFactory.getLogger(PredictionCatalogueApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PredictionCatalogueApplication.class, args);
	}

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshEvent(ContextRefreshedEvent contextRefreshedEvent) {
		ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
		String dbUrl = applicationContext.getEnvironment().getProperty("spring.datasource.url");
		log.info("Connected to postgres: " + dbUrl);
		MDC.put("applicationName", applicationContext.getId());
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("rso.predictioncatalogue"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(List.of(apiKey()))
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Prediction catalogue API",
				"This is a private API for League of Legends predictor application",
				"1.0",
				"Students license",
				new Contact("Jakob Maležič", "https://github.com/Blarc", "jm6421@student.uni-lj.si"),
				"API License",
				"https://google.com",
				Collections.emptyList()
		);
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	//    @Bean
	//    public Hibernate5Module hibernate5Module() {
	//        return new Hibernate5Module();
	//    }

}
