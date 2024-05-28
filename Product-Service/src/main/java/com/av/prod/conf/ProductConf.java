package com.av.prod.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class ProductConf {

    @Bean
    public Docket aoi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Products")
                //.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.av.prod"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Product API")
                .description("E-commerce Product Service Details")
                .contact(new Contact("Abhimanyu Kumar","www.av.in","abhimanyu392kumar@gmail.com"))
                .license("Gmail 2.0")
                .licenseUrl("just4abhimanyu")
                .version("1.0")
                .build();
    }
}
