package team.calistis.command;

import cn.nukkit.command.Command;
import team.calistis.Core;
import team.calistis.command.types.EconomyCommand;
import team.calistis.zcore.command.CoreCommand;

public class CommandManager {

  public static void init() {
  }

  private static void registerCommands(CoreCommand... commands) {
    for (Command command : commands) {
      Core.getInstance().getServer().getCommandMap().register(command.getName(), command);
    }
  }

}
