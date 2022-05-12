package team.calistis.manager.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import team.calistis.Calistis;

public class RankCommandManager implements CommandExecutor {

  private final Calistis calistis;

  public RankCommandManager(Calistis calistis) {
    this.calistis = calistis;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    return false;
  }

  public Calistis getCalistis() {
    return calistis;
  }

}
