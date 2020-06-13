package com.sasori.personapi.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static springfox.documentation.builders.PathSelectors.regex;

@Getter
@Setter
@Component
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@ConfigurationProperties(prefix = "swagger")
public class SpringFoxConfig {

    private static final String API_KEY = "Token";
    private static final String HEADER = "header";
    private static final String AUTHORIZATION = "Authorization";
    private static final String URL = "https://www.ingjulianvega.com/";
    private static final String EMAIL = "ingjulianega@gmail.com";

    private boolean allowed;
    private Api api;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.sasori"))
                .paths(regex("/.*")).build()
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()))
                .useDefaultResponseMessages(true)
                .enable(allowed);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(api.getTitle())
                .description(api.getDescription())
                .version(api.getVersion())
                .contact(new Contact(EMPTY, URL, EMAIL)).build();
    }

    private ApiKey apiKey() {
        return new ApiKey(API_KEY, AUTHORIZATION, HEADER);
    }

    private SecurityContext securityContext() {
        return SecurityContext
                .builder()
                .securityReferences(defaultAuth())
                .forPaths(regex("/*"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference(API_KEY, authorizationScopes));
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }

    @Getter
    @Setter
    public static class Api {

        private String title;
        private String version;
        private String description;
    }
}
