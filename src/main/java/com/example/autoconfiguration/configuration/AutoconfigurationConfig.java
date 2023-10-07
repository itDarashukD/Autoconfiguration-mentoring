package com.example.autoconfiguration.configuration;


import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
public class AutoconfigurationConfig {

    @Primary
    @Bean(name = "h2Datasource")
    @ConditionalOnProperty(name = "spring.h2.console.enabled", havingValue = "true")
    DataSource h2Datasource() {
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.driverClassName("org.h2.Driver");
//        builder.url("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1");
//        builder.username("SA");
//        builder.password("");

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
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.driverClassName("org.hsqldb.jdbc.JDBCDriver");
//        builder.url("jdbc:hsqldb:mem:localdb;sql.syntax_pgs=true;DB_CLOSE_DELAY=-1");
//        builder.username("");
//        builder.password("");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType( EmbeddedDatabaseType.HSQL)
                .addScript("/scripts/hsql/schema-hsqldb.sql")
                .addScript("/scripts/hsql/data-hsqldb.sql")
                .build();



        return builder.build();
    }


}



