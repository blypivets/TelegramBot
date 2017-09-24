package storages.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 24.09.17.
 */
public abstract class BotConnection {

    private Connection connection = null;

    public ResultSet runSqlQuery(String query) throws SQLException {

        Statement statement;
        statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        return rs;
    }
}
