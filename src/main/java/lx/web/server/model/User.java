package lx.web.server.model;

import java.util.Objects;

/**
 * User
 *
 */
public class User {

  private final String login;
  private final String password;
  private String email;

  public User(final String login, final String password) {
    this.login = login;
    this.password = password;
  }

  public User(final String login, final String password, final String email) {
    this(login, password);
    this.email = email;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;

    if (o == null || this.getClass() != o.getClass())
      return false;

    User user = (User) o;

    return Objects.equals(this.login, user.login);
  }
}
