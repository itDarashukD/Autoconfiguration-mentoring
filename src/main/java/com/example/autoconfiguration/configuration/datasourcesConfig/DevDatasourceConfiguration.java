package com.example.autoconfiguration.configuration.datasourcesConfig;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile(value = "dev")
public class DevDatasourceConfiguration {

    @Bean(name = "devHsqlDataSource")
    public DataSource devHsqlDataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType( EmbeddedDatabaseType.HSQL)
                .addScript("/scripts/hsql/schema-hsqldb.sql")
                .addScript("/scripts/hsql/data-hsqldb.sql")
                .build();

        return builder.build();
    }


}
