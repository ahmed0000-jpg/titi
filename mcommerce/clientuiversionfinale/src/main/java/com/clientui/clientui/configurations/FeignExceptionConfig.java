package com.clientui.clientui.configurations;

import com.clientui.clientui.exception.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignExceptionConfig {

    @Bean
    public CustomErrorDecoder mCustemErrorDecoder(){
        return new CustomErrorDecoder();
    }
}
