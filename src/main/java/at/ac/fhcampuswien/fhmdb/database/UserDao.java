package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public interface UserDao {
    int createUser(User user) throws SQLException;
    User getUserById(int id) throws SQLException;
    // Weitere Methoden nach Bedarf
}

class UserDaoImpl implements UserDao {
    private Dao<User, Integer> userDao;

    public UserDaoImpl(ConnectionSource connectionSource) throws SQLException {
        userDao = DaoManager.createDao(connectionSource, User.class);
    }

    public int createUser(User user) throws SQLException {
        return userDao.create(user);
    }

    public User getUserById(int id) throws SQLException {
        return userDao.queryForId(id);
    }
}
