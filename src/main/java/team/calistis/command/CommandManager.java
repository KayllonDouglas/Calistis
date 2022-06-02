package team.calistis.command;

import team.calistis.Core;
import team.calistis.zcore.command.CoreCommand;

public class CommandManager {

  private final Core core;

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
