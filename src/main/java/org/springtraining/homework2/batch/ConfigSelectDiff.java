package org.springtraining.homework2.batch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springtraining.homework2.select.Config;

import javax.sql.DataSource;


@Configuration
//@Import(Config.class)
public class ConfigSelectDiff {

    @Bean
    DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("script-jdbc.sql")
                .generateUniqueName(true)
                .build();
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

//    @Bean
//    public SimpleJdbcInsert insertOutput(DataSource dataSource) {
//        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
//        simpleJdbcInsert.withTableName("OUTPUT_TABLE");
//        simpleJdbcInsert.usingColumns("name", "diff_min");
//
//        return simpleJdbcInsert;
//    }
}
