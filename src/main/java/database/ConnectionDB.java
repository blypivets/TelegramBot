package database;

import java.sql.*;

public class ConnectionDB {

    private String dbName = System.getenv("DATABASE_NAME");
    private String userName = System.getenv("USER_NAME");
    private String password = System.getenv("PASSWORD_DB");

    private Connection connection = null;

    public void connection(){

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/" +
                    dbName,
                    userName,
                    password);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connection complete!");
        } else {
            System.out.println("Connection failed!");
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