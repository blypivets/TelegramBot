package database;


import org.telegram.telegrambots.logging.BotLogger;

import java.sql.*;

/**
 * Created by Victor on 25.03.2017.
 */
public class ConnectionDB {

    private Connection currentConection;

    public ConnectionDB() {
        this.currentConection = openConexion();
    }

    private Connection openConexion(){

        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TELEGRAMBOTSQL", "kotletkobot");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConexion() {
        try {
            this.currentConection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet runSqlQuery(String query) throws SQLException {
        final Statement statement;
        statement = this.currentConection.createStatement();
        return statement.executeQuery(query);
    }
}
