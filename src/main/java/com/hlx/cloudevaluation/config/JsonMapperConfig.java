package com.hlx.cloudevaluation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: JsonMapper配置类
 * @author: hlx 2018-10-03
 **/
@Configuration
public class JsonMapperConfig {

    @Bean
    public ObjectMapper jsonMapper() {
        return new ObjectMapper();
    }

}
