package database;

import java.sql.*;

public class ConnectionDB {

    private Connection connection = null;

    public void connection(){

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String dbName = System.getenv("DATABASE_NAME");
        String userName = System.getenv("USER_NAME");
        String password = System.getenv("PASSWORD_DB");

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/" +
                    dbName,
                    userName,
                    password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connection complete!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public void closeConexion() {
        try {
            this.connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet runSqlQuery(String query) throws SQLException {

        Statement statement;
        statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        return rs;
    }
}