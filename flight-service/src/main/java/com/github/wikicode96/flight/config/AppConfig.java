package com.github.wikicode96.flight.config;

import com.github.wikicode96.flight.dto.FlightDTO;
import com.github.wikicode96.flight.entity.FlightEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<FlightEntity, FlightDTO>() {
            @Override
            protected void configure() {
                map().setAirline(source.getAirline().getName());
            }
        });

        return modelMapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
