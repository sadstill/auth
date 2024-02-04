package org.example.config;

import org.example.bean.Customer;
import org.example.bean.IWaiter;
import org.example.bean.Waiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class ApplicationConfig {
    @Bean
    public IWaiter john() {
        return new Waiter("John");
    }

    @Bean
    public Customer andrew() {
        return new Customer("Andrew");
    }

    @Bean
    public Customer julia() {
        return new Customer("Julia");
    }

    @Bean
    public Customer nina() {
        return new Customer("Nina");
    }
}
