package com.project;

import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class DbInitApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DbInitApplication.class, args);
    }

    @PostConstruct
    public void init() throws SQLException {
        exec(dataSource, "sql/psiworm.sql");
    }

    private void exec(DataSource accountDatasource, String script) throws SQLException {
        ClassPathResource rc = new ClassPathResource(script, DbInitApplication.class.getClassLoader());
        EncodedResource er = new EncodedResource(rc, "utf-8");
        ScriptUtils.executeSqlScript(accountDatasource.getConnection(), er);
    }
}