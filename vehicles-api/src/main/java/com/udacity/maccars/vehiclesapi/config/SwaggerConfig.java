package com.udacity.maccars.vehiclesapi.config;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.RequestHandlerProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation."),
        @ApiResponse(code=500, message = "The server is down.")
})
public class SwaggerConfig {
    //Method to add Swagger
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    //Contact info about API
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Mac-cars REST API",
                "This API returns a vehicles, prices and addresses.",
                "1.0",
                "http://www.udacity.com/tos",
                new Contact("Yana Makogon", "www.udacity.com", "yana_makogon@udacity.com"),
                "License of API", "http://www.udacity.com/license", Collections.emptyList());
    }

}
