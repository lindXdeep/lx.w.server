package lx.web.server.dao;

/**
 * AccountService
 */
public interface UserDao {

  boolean signin(String login, String password);

  void signup(String login, String password);
}
