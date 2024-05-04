package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DATABASE_URL = "jdbc:h2:./db/fhmdb";
    private static final String USERNAME = "class";
    private static final String PASSWORD = "cisco";

    private static ConnectionSource connectionSource;
    private static UserDao userDao;

    public static ConnectionSource getConnectionSource() throws SQLException {
        if (connectionSource == null) {
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException("H2 JDBC driver not found", e);
            }
            connectionSource = new JdbcConnectionSource(DATABASE_URL, USERNAME, PASSWORD);
        }
        return connectionSource;
    }

    public static UserDao getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = new UserDaoImpl(getConnectionSource());
        }
        return userDao;
    }
}
