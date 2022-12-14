package digital.Cloud.Park.Controller;

import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.SQLOutput;

public abstract class AbstractContainerBase {

    static final PostgreSQLContainer POSTGRE_SQL_CONTAINER;

    static {
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:latest");
        POSTGRE_SQL_CONTAINER.start();
        System.setProperty("spring.datasource.url", POSTGRE_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.username", POSTGRE_SQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.password", POSTGRE_SQL_CONTAINER.getPassword());

    }
}
