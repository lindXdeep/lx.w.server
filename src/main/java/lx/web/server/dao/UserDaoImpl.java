package lx.web.server.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lx.web.server.model.User;

/**
 * AccountServiceInpl
 */
public class UserDaoImpl implements UserDao {

  private Map<String, User> signedUpUsers = new ConcurrentHashMap<>();

  @Override
  public boolean signin(final String login, final String password) {

    User user = signedUpUsers.get(login);
    return user != null && user.getPassword().equals(password);
  }

  @Override
  public void signup(final String login, final String password) {

    signedUpUsers.put(login, new User(login, password));
  }
}
