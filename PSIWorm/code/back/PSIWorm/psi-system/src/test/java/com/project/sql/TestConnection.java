package com.project.sql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class TestConnection {
    @Autowired
    private DataSource dataSource;
    @Test
    public void method() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
