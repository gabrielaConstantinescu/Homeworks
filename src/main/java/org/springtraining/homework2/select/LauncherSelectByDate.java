package org.springtraining.homework2.select;

import org.h2.tools.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

public class LauncherSelectByDate {

    public static void main(String[] args) throws IOException {
        String pkg = "org.springtraining.homework2.select";
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(pkg)) {

            startConsole(context.getBean(DataSource.class));
            String date = "2018-01-26 10:15:58";
            System.out.print("Result: ");
            System.out.println(context.getBean(Processor.class).process(date));

            System.out.println("Press any key to exit");
            System.in.read();
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
