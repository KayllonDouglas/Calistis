package team.calistis.commands;

import team.calistis.Calistis;
import team.calistis.commands.types.BankCommand;

public class CommandManager {

  private Calistis core;

  public CommandManager(Calistis core) {
    this.core = core;
    this.registerCommand(new BankCommand());
    this.unregisterCommand("me");
  }

  public void unregisterCommand(String name) {
    this.core.getServer()
        .getCommandMap()
        .getCommand(name)
        .unregister(this.core.getServer().getCommandMap());
  }

  public void registerCommand(CoreCommand command) {
    this.core.getServer()
        .getCommandMap()
        .register(command.getName(), command);
  }

  public Calistis getCore() {
    return core;
  }

}
