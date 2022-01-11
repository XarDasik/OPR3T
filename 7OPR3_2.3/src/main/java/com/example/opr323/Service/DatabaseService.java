package com.example.opr323.Service;

import com.example.opr323.Model.Person;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private static final String URL = "jdbc:derby://127.0.0.1:1527/Person";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    public void insert(Person person){
        try {

            java.sql.Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            java.sql.PreparedStatement statement =
                    connection.prepareStatement(
                            "insert into Person(name, surname) values (?,?)");
            statement.setString(1, person.getName());
            statement.setString(2, person.getSurname());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Person> get(){
        List<Person> people = new ArrayList<>();
        try {

            java.sql.Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            java.sql.PreparedStatement statement =
                    connection.prepareStatement(
                            "select * from Person");
            ResultSet set = statement.executeQuery();

        while(set.next()){
            people.add(new Person(set.getString(2), set.getString(3)));
        }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }
}
