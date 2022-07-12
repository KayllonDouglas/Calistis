package github.kayllondouglas.command;

import cn.nukkit.command.CommandSender;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public abstract class Command extends cn.nukkit.command.Command {

  private final Map<String, SubCommand> subCommands;

  public Command(String name) {
    super(name);
    this.subCommands = new HashMap<>();
  }

  public Command(String name, String description) {
    super(name, description);
    this.subCommands = new HashMap<>();
  }

  public Command(String name, String description, String usageMessage) {
    super(name, description, usageMessage);
    this.subCommands = new HashMap<>();
  }

  public Command(String name, String description, String usageMessage, String[] aliases) {
    super(name, description, usageMessage, aliases);
    this.subCommands = new HashMap<>();
  }

  public SubCommand getSubCommand(String name) {
    return this.subCommands.get(name);
  }

  public boolean existsSubCommand(String name) {
    return this.subCommands.containsKey(name);
  }

  @SneakyThrows
  public SubCommand registerSubCommand(String name, SubCommand subCommand) {
    if (existsSubCommand(name))
      throw new Exception("The SubCommand " + name + " is already registered.");
    return this.subCommands.put(name, subCommand);
  }

  public abstract boolean execute(CommandSender sender, String label, String[] args);

  public Map<String, SubCommand> getSubCommands() {
    return subCommands;
  }

}
