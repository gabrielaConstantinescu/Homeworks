package org.springtraining.homework2.batch;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springtraining.homework2.select.Processor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class SelectDifferencesInMin implements Processor<String, String> {


    private JdbcTemplate template;

    public SelectDifferencesInMin(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }


    @Override
    public String process(String in) {

        List<Object[]> batches = template.query(
                "SELECT name, date_out, date_in FROM INPUT_TABLE",
                (rs, i) ->
                        new Object[]{rs.getString("name"), rs.getString("date_in"), rs.getString("date_out")});

        System.out.println("BATCHES SIZE   " + batches.size());

        List<OutputEntity> insertIntoOutputList = calculateDiffForBatches(batches);

        insertBatchIntoOutput(insertIntoOutputList, 10);
//        List<Object[]> result = template.query(
//                "SELECT name FROM OUTPUT_TABLE",
//                (rs, i) ->
//                        new Object[]{rs.getString("name")});
//        System.out.println("RESULTTTTTTT     " + result.size());
        return "SUCCESS";
    }


    private List<OutputEntity> calculateDiffForBatches(List<Object[]> batches){
        List<OutputEntity> result = new ArrayList<>();
        long diff = 0;
        Timestamp outTimestamp = null;
        Timestamp inTimestamp = null;
        for (Object[] o : batches){
            outTimestamp = Timestamp.valueOf(o[2].toString());
            inTimestamp = Timestamp.valueOf(o[1].toString());
            diff = outTimestamp.getTime() - inTimestamp.getTime();
            result.add(new OutputEntity(o[0].toString(), diff/60000));
        }

        return result;
    }


    private void insertBatchIntoOutput(List<OutputEntity> outputList, int maxPerBatch) {
        template.batchUpdate("INSERT INTO OUTPUT_TABLE (name, minutes) values (?, ?)", outputList,
                maxPerBatch, (ps, outputObj) -> {
                    ps.setString(1, outputObj.getName());
                    ps.setLong(2, outputObj.getDiffMinutes());
                });
    }
}
