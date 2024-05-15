package com.dnrea.edu.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class cloudinaryConfig {

    @Bean
    public ModelMapper mapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Cloudinary cloudinary() {
        @SuppressWarnings("rawtypes")
        Map map = new HashMap<>();
        map.put("cloud_name", "drv8ak3r0");
        map.put("api_key", "429262731349689");
        map.put("api_secret", "2xxmvRlu2qB7x__JtdhgNueP4hc");
        map.put("secure", true);

        return new Cloudinary(map);
    }

}
