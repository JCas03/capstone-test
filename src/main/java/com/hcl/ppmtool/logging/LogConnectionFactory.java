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
            dataSource.setUrl("jdbc:mysql://cong-azure.mysql.database.azure.com:3306/capstone");
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("congcapstoneazure");
            dataSource.setPassword("ZRIJmLYLjImPquRDLOnmr5rhpM0woTDp");
        }
        return dataSource.getConnection();
    }
}




