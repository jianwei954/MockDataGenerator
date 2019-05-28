package com.jw.mockdata.generator.config;

import com.jw.mockdata.generator.util.PropertiesUtil;
import com.jw.mockdata.generator.util.SpringUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by dell on 2017/3/19.
 */

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:"+ PropertiesUtil.dir+"/static/");
        super.addResourceHandlers(registry);
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException, JsonProcessingException
            {
                jsonGenerator.writeString("");
            }
        });
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        converters.add(mappingJackson2HttpMessageConverter);
    }

    @Bean(name = "mySpringUtil")
    public SpringUtil getSpringUtil() {
        SpringUtil springUtil = new SpringUtil();
        return springUtil;
    }
}
