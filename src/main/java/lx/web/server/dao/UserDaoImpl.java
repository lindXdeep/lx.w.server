package lx.web.server.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lx.web.server.model.User;

/**
 * AccountServiceInpl
 */
public class UserDaoImpl implements UserDao {

  private Map<String, User> userlogged = new ConcurrentHashMap<>();
  private Map<String, User> userSession = new ConcurrentHashMap<>();

  @Override
  public void addNewUser(final User user) {

    userlogged.put(user.getLogin(), user);
  }

  @Override
  public User getUserByLogIn(final String login) {

    return userlogged.get(login);
  }

  @Override
  public User getUserBySessionId(final String sessionId) {

    return userSession.get(sessionId);
  }

  @Override
  public void addSession(final String sessionId, final User user) {

    userSession.put(sessionId, user);
  }

  @Override
  public void deleteSession(final String sessionId) {

    userSession.remove(sessionId);
  }
}
