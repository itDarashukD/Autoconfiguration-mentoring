package com.example.autoconfiguration.configuration;


import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Profile("developing")
@Configuration
public class AutoconfigurationConfig {

    @Primary
    @Bean(name = "h2Datasource")
    @ConditionalOnProperty(name = "spring.h2.console.enabled", havingValue = "true")
    DataSource h2Datasource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType( EmbeddedDatabaseType.H2)
                .addScript("/scripts/h2/schema.sql")
                .addScript("/scripts/h2/data.sql")
                .build();

        return builder.build();
    }

    @ConditionalOnMissingBean(name = "h2Datasource")
    @Bean(name = "hsqlDatasource")
    DataSource hsqlDatasource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType( EmbeddedDatabaseType.HSQL)
                .addScript("/scripts/hsql/schema-hsqldb.sql")
                .addScript("/scripts/hsql/data-hsqldb.sql")
                .build();

        return builder.build();
    }


}



