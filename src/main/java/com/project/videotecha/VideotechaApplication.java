package com.project.videotecha;

import com.project.videotecha.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class VideotechaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideotechaApplication.class, args);
    }

}
