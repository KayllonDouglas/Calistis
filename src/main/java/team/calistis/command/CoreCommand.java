package team.calistis.command;

import java.util.HashMap;
import java.util.Map;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import lombok.SneakyThrows;

public abstract class CoreCommand extends Command {

  private Map<String, SubCommand> subCommands;

  public CoreCommand(String name, String description, String usageMessage, String[] aliases) {
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

  public abstract boolean execute(CommandSender arg0, String arg1, String[] arg2);

  public Map<String, SubCommand> getSubCommands() {
    return subCommands;
  }

}
