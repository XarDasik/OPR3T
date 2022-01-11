package com.example.opr323.Service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.opr323.Model.Access;
import com.example.opr323.Model.Record;
public class DatabaseService {
    private static final String URL = "jdbc:derby://127.0.0.1:1527/ShareText";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    public static boolean insertToUserText(Record record){
        try {
            java.sql.Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);
            java.sql.PreparedStatement statement =
                    connection.prepareStatement(
                            "insert into UserText(words, text, pin) values (?,?,?)");
            statement.setString(1, record.getAccess().getCode());
            statement.setString(2, record.getText());
            statement.setString(3, record.getAccess().getPin());
            statement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static Record getUserText(Access access){
        try {
            java.sql.Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);
            java.sql.PreparedStatement statement =
                    connection.prepareStatement(
                            "select * from UserText");
            ResultSet resultSet= statement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString(1).equals(access.getCode()) && resultSet.getString(3).equals(access.getPin())){
                    return new Record(resultSet.getString(2), access);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static boolean isUserTextFree(String words){
        try {
            java.sql.Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);
            java.sql.PreparedStatement statement =
                    connection.prepareStatement(
                            "select * from UserText");
            ResultSet resultSet= statement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString(1).equals(words) ){
                    return false;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    public static void insertToWords(String word){
        try {
            java.sql.Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);
            java.sql.PreparedStatement statement =
                    connection.prepareStatement(
                            "insert into Words(word) values (?)");
            statement.setString(1, word);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static String getWord(int id){
        try {
            java.sql.Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);
            java.sql.PreparedStatement statement =
                    connection.prepareStatement(
                            "select * from words");
            ResultSet resultSet= statement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getInt(1) == id){
                    return resultSet.getString(2);
                }
            }

            return resultSet.getString(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
