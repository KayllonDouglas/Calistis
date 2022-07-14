package github.kayllondouglas.commands;

import java.util.HashMap;
import java.util.Map;

import cn.nukkit.command.CommandSender;
import github.kayllondouglas.commands.exceptions.SubCommandRegistrationException;

public class Command extends cn.nukkit.command.Command {

  private final Map<String, SubCommand> subCommands = new HashMap<>();

  public Command(String name) {
    super(name);
  }

  public Command(
      String name,
      String description) {
    super(
        name,
        description);
  }

  public Command(
      String name,
      String description,
      String usageMessage) {
    super(
        name,
        description,
        usageMessage);
  }

  public Command(
      String name,
      String description,
      String usageMessage,
      String[] aliases) {
    super(
        name,
        description,
        usageMessage,
        aliases);
  }

  public SubCommand registerSubCommand(String subCommandName, SubCommand subCommand)
      throws SubCommandRegistrationException {
    if (this.subCommands.containsKey(subCommandName))
      throw new SubCommandRegistrationException(
          String.format("The `%s` subCommand is already registered.", subCommandName));
    return this.subCommands.put(subCommandName, subCommand);
  }

  public SubCommand getSubCommand(String subCommandName) {
    return this.subCommands.get(subCommandName);
  }

  @Override
  public boolean execute(
      CommandSender commandSender,
      String commandLabel,
      String[] arguments) {
    return true;
  }

  public Map<String, SubCommand> getSubCommands() {
    return subCommands;
  }

}
