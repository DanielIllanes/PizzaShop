package com.pizzashop.pizzashop;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzashopApplication {

    public static void main(String[] args) {
        // Create the Flyway instance
        Flyway flyway = new Flyway();

        // Point it to the database
        flyway.setDataSource("jdbc:h2:file:./target/pizzashop", "sa", null);

        // Start the migration
        flyway.migrate();

        SpringApplication.run(PizzashopApplication.class, args);
    }
}
