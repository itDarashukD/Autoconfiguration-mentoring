package com.example.autoconfiguration.configuration.datasourcesConfig;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile(value = "qa")
public class QADatasourceConfiguration {

    @Bean(name = "qaH2DataSource")
    public DataSource qaH2DataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db =
	       builder.setType(EmbeddedDatabaseType.H2)
		      .addScript("/scripts/h2/schema.sql")
		      .addScript("/scripts/h2/data.sql")
		      .build();

        return builder.build();

    }
}
