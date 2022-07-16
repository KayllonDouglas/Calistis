package github.kayllondouglas.commands.exceptions;

public class SubCommandException extends Exception {

  public SubCommandException(String message) {
    super(message);
  }

  public SubCommandException(String message, Throwable throwable) {
    super(message, throwable);
  }

}
