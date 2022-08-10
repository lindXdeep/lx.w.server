package lx.web.server.service;

import lx.web.server.model.User;

/**
 * AccountService
 */
public interface AccountService {

  public void addNewUser(User User);

  public User getUserByLogIn(String login);

  public User getUserBySessionId(String sessionId);

  public void addSession(String sessionId, User user);

  public void deleteSession(String sessionId);

}
