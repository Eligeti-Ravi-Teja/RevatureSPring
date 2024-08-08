package org.example.config;

import org.example.dao.AtmDao;
import org.example.service.AtmService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ApplicationConfig {
}
