package storages.database;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class ConnectionDB {

    //private String dbName = "d2b30fglohbagh";
    //private  String ssl = "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    private String userName = "shddthktnqequs";
    private String password = "653d148e20baec05a6a5afb5c7d48405c971ff15b556eda54e7b8389820b4ede";

    private Connection connection = null;

    public void connection(){

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