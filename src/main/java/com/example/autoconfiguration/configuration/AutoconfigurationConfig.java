package com.example.autoconfiguration.configuration;


import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AutoconfigurationConfig {

    @Bean
    DataSource datasource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName("org.h2.Driver");
        builder.url("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false");
        builder.username("SA");
        builder.password("");

        return builder.build();
    }


}
