package com.crew92.doordie.content.api.configuration;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private static final String SWAGGER_UI_PATH = "swagger-ui.html";
    private static final String WEBJARS_PATH = "/webjars/**";

    @Bean
    public Docket api() {
        return new Docket(SWAGGER_2)
            .groupName("Content-api")
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/" + SWAGGER_UI_PATH);
        registry.addRedirectViewController("/swagger", "/" + SWAGGER_UI_PATH);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(SWAGGER_UI_PATH)
            .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler(WEBJARS_PATH)
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
