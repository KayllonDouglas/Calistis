package team.calistis.command;

import team.calistis.Core;
import team.calistis.command.types.BankCommand;

public class CommandManager {

  private Core core;

  public CommandManager(Core core) {
    this.core = core;
    this.unregisterCommand("me");
    this.registerCommand(new BankCommand());
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

  public Core getCore() {
    return core;
  }

}
