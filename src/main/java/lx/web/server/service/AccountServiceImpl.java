package lx.web.server.service;

import lx.web.server.dao.UserDao;
import lx.web.server.dao.UserDaoImpl;

/**
 * AccountServiceImpl
 */
public class AccountServiceImpl implements AccountService {

  private UserDao userDao = new UserDaoImpl();

  @Override
  public boolean signin(String login, String password) {

    return userDao.signin(login, password);
  }

  @Override
  public void signup(String login, String password) {

    userDao.signup(login, password);
  }
}
