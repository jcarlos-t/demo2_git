package org.edu.demo.demo2.confi;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo2Confi {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
