package lx.web.server.service;

import lx.web.server.dao.UserDao;
import lx.web.server.dao.UserDaoImpl;
import lx.web.server.model.User;

/**
 * AccountServiceImpl
 */
public class AccountServiceImpl implements AccountService {

  private UserDao userDao = new UserDaoImpl();

  @Override
  public void addNewUser(final User User) {

    userDao.addNewUser(User);
  }

  @Override
  public User getUserByLogIn(final String login) {

    return userDao.getUserByLogIn(login);
  }

  @Override
  public User getUserBySessionId(final String sessionId) {

    return userDao.getUserByLogIn(sessionId);
  }

  @Override
  public void addSession(final String sessionId, final User user) {

    userDao.addSession(sessionId, user);
  }

  @Override
  public void deleteSession(final String sessionId) {

    userDao.deleteSession(sessionId);
  }
}

