package com.tracesystem.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by 刘佳 on 2019-03-15 16:13
 **/
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

        @Bean
        public HttpMessageConverter<String> responseBodyConverter() {
            StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
            return converter;
        }

        @Bean
        public ObjectMapper getObjectMapper() {
            return new ObjectMapper();
        }
        @Bean
        public MappingJackson2HttpMessageConverter messageConverter() {
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setObjectMapper(getObjectMapper());
            return converter;
        }

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            super.configureMessageConverters(converters);
            //解决中文乱码
            converters.add(responseBodyConverter());
            //解决 添加解决中文乱码后 上述配置之后，返回json数据直接报错 500：no convertter for return value of type
            converters.add(messageConverter());
        }

        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.favorPathExtension(false);
        }

}

