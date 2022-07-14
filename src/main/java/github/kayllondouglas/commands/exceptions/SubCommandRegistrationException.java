package github.kayllondouglas.commands.exceptions;

public class SubCommandRegistrationException extends Exception {

  public SubCommandRegistrationException(String message) {
    super(message);
  }

  public SubCommandRegistrationException(String message, Throwable throwable) {
    super(message, throwable);
  }

}
