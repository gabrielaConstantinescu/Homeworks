package org.springtraining.homework2.batch;

import org.h2.tools.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springtraining.homework2.select.Processor;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

public class LauncherSelectDiffInMinutes {

    public static void main(String[] args) throws IOException {
        String pkg = "org.springtraining.homework2.batch";
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(pkg)) {

            startConsole(context.getBean(DataSource.class));
            System.out.print("Result: ");
            String in = "";
            System.out.println(context.getBean(Processor.class).process(in));

            System.out.println("Press any key to exit");

        }
        System.exit(0);
    }

    public static void startConsole(DataSource dataSource){
        Thread t = new Thread(() -> {
            try {
                Server.startWebServer(dataSource.getConnection());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, "h2-console");
        t.setDaemon(true);
        t.start();
    }


}
