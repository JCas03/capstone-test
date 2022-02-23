package com.hcl.ppmtool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PpmtoolApplication {
    static Logger log = LogManager.getLogger(PpmtoolApplication.class);

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    public static void main(String[] args) {
    	PropertyConfigurator.configure("src/main/resources/log4j.properties");
		log.warn("DB accessed authorized from Application..");
        SpringApplication.run(PpmtoolApplication.class, args);
    }
}
