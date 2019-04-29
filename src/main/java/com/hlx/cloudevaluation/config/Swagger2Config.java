package com.hlx.cloudevaluation.config;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: Swagger2配置类, 构建api文档
 * @author: hlx 2018-08-14
 **/
@Setter
@Configuration
@EnableSwagger2
@Profile({"dev","test"})
public class Swagger2Config {


    @Value("${swagger.host}")
    private String swaggerHost;

    @Bean
    public Docket docket() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("S-TOKEN")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(ticketPar.build());

        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        if (StringUtils.isNotBlank(swaggerHost)) {
            docket = docket.host(swaggerHost);
        }
        return docket
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hlx.cloudevaluation.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Evaluation-API")
                .description("云评-API文档")
                .termsOfServiceUrl("https://github.com/hlxing/cloud-evaluation")
                .contact(new Contact("hlx", "https://github.com/hlxing", "603773962@qq.com"))
                .version("1.0")
                .build();
    }

}
