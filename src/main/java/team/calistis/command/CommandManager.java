package team.calistis.command;

import team.calistis.Core;

public class CommandManager {

  private Core core;

  public CommandManager(Core core) {
    this.core = core;
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
