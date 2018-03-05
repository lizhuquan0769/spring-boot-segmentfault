package com.segmentfault.springboot.lession8.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DozerConfiguration {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {

        List<String> mappingFiles = Arrays.asList("dozer/dozer-mapping-configuration.xml");
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper(mappingFiles);
        return dozerBeanMapper;
    }

}
