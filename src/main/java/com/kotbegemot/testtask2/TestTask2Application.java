package com.kotbegemot.testtask2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Main class of Newsline application
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.kotbegemot.testtask2.repository.jpa")
@EnableTransactionManagement
public class TestTask2Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(TestTask2Application.class, args);
    }
}
