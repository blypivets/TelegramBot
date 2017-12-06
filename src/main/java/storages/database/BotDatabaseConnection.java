package storages.database;

import java.sql.*;

/**
 * Created by user on 24.09.17.
 */

public abstract class BotDatabaseConnection {

    private Connection connection = null;

    public ResultSet runSqlQuery(String query) throws SQLException {

        PreparedStatement ps = this.connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        return rs;
    }
}
