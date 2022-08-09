package lx.web.server.service;

/**
 * AccountService
 */
public interface AccountService {

  boolean signin(String login, String password);

  void signup(String login, String password);
}
