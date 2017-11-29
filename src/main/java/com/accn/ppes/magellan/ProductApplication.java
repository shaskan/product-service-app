package com.accn.ppes.magellan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class ProductApplication {
	
	  public static void main(String[] args) {
			SpringApplication.run(ProductApplication.class, args);
		}
	  
	  @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("com.accn.ppes.magellan"))              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
		 private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("Product API")
					.description("Product API reference for developers")
					.contact("ramarao.ariyaram@accenture.com").license("Product API License")
					.licenseUrl("ramarao.ariyaram@accenture.com").version("1.0").build();
		}
}
