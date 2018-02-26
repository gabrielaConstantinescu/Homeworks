package org.springtraining.homework2.select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class SelectAllProcessor implements Processor<String, List<String>>{

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public SelectAllProcessor(JdbcTemplate template){
        this.jdbcTemplate = template;
    }

    @Override
    public List<String> process(String in) {
        return jdbcTemplate.queryForList("SELECT name FROM input_table where date_in = ?", new Object[]{Timestamp.valueOf(in)}, String.class);

    }

}
