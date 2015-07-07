package com.nike.mm

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchAutoConfiguration
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchDataAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@SuppressWarnings("all")
@EnableAutoConfiguration(exclude=[ElasticsearchDataAutoConfiguration, ElasticsearchAutoConfiguration])
@ComponentScan
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
class MeasurementorApplication extends SpringBootServletInitializer {

    static void main(String[] args) {
        SpringApplication.run MeasurementorApplication, args
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootAwsApplication.class);
    }
}
