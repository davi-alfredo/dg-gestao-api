package com.dg.gestao.swagger;

import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {

//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)          
//          .select()
//          .apis(RequestHandlerSelectors.basePackage("com.dg.gestao.controller"))          
//          .paths(PathSelectors.any())
//          .build()
//          .apiInfo(apiInfo());
//    }
//	
//	private ApiInfo apiInfo() {
//	    return new ApiInfoBuilder()
//	            .title("DG Gestão")
//	            .description("Gestão DG Locadora")
//	            .termsOfServiceUrl("http://www.dglocadora.com.br")
//	            .contact(new Contact("David", "", "davi.alfredo@hotmail.com"))
//	            .build();
//	}
//	
//	@Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");        
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
	
}
