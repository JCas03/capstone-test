package com.hcl.ppmtool.logging;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class LogConnectionFactory {

    private static BasicDataSource dataSource;

    private LogConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://jc-azure.mysql.database.azure.com:3306/demo");
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("azuredemo");
            dataSource.setPassword("!Demo1234");
        }
        return dataSource.getConnection();
    }
}




