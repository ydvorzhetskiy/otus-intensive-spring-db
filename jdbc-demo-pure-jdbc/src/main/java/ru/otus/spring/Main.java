package ru.otus.spring;

import lombok.val;
import org.h2.tools.Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        try(Connection connection = DriverManager.getConnection(
            "jdbc:h2:mem:testdb", "sa", "")
        ) {
            try(Statement statement = connection.createStatement()) {
                statement.execute(
                    "CREATE TABLE PERSONS(ID BIGINT PRIMARY KEY, NAME VARCHAR(255));"
                );
                statement.execute(
                    "insert into persons (id, `name`) values (1, 'masha');"
                );

                try(ResultSet rs = statement.executeQuery("select * from persons")) {
                    while(rs.next()) {
                        System.out.println("id: " + rs.getInt("id"));
                        System.out.println("name: " + rs.getString("name"));
                    }
                }
            }
        }
    }
}
