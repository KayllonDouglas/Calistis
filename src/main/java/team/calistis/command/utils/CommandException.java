package team.calistis.command.utils;

public class CommandException extends Exception {

  public CommandException(String message) {
    super(message);
  }

  public CommandException(String message, Throwable throwable) {
    super(message, throwable);
  }

}
