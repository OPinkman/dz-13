package utils;

import com.rd.manwoman.Man;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {

    private final static String URL = "jdbc:postgresql://localhost:4567/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "postgres";
    private final static String QUERY_SELECT = "select * from people";
    private final static String QUERY_INSERT = "insert into people (firstNameMan, lastNameMan, genderMan, ageMan, partnerMan) values (?,?,?,?,?)";
    private final static String QUERY_UPDATE = "update people set firstNameMan=? where id=?";
    private final static String QUERY_DELETE = "delete from people where firstNameMan=? and lastNameMan=?";

        public static List<Man> getPersonFromDB() {
            List<Man> mans = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Man man = new Man(resultSet.getString("firstnameman"), resultSet.getString("lastnameman"), resultSet.getString("genderman"), resultSet.getInt("ageman"), resultSet.getString("partnerman"));
                    mans.add(man);
                }
            } catch (SQLException exception) {
                throw new RuntimeException("Something wrong with DB connection or select method");
            }
            return mans;

    }

    public static void insertPersonFromDB() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, "Orlan");
            preparedStatement.setString(2, "Petyhov");
            preparedStatement.setString(3, "Non-binary");
            preparedStatement.setInt(4, 44);
            preparedStatement.setString(5, null);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Something wrong with DB connection or insert method");
        }
    }
    public static void updatePersonFromDB() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, "Pedro");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Something wrong with DB connection or update method");
        }
    }
    public static void deletePersonFromDB() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setString(1, "Orlan");
            preparedStatement.setString(2, "Petyhov");
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Something wrong with DB connection or delete method");
        }
    }
}