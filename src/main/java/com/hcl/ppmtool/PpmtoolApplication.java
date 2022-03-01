package com.hcl.ppmtool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PpmtoolApplication {

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static final Logger log = LogManager.getLogger(PpmtoolApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(PpmtoolApplication.class, args);
        log.warn("Beginning of application");

    }
}
