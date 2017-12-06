package storages.database;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class OneTimeConnectionToDB extends BotDatabaseConnection {

    private Connection connection = null;

    public OneTimeConnectionToDB() {

        this.connection = getConnection();
    }

    public Connection getConnection(){

        try {

            Class.forName("org.postgresql.Driver");

            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

            connection = DriverManager.getConnection(dbUrl, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeConnection() {
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