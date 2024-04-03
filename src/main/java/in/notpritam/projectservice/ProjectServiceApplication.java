package in.notpritam.projectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectServiceApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "3000");
        SpringApplication.run(ProjectServiceApplication.class, args);
    }

}
