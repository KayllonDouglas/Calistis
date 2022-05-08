package team.calistis.command.core;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import team.calistis.Calistis;
import team.calistis.command.core.base.AboutCommand;

import java.util.ArrayList;
import java.util.List;

public class CalistisCommandManager implements CommandExecutor {

  private final Calistis calistis;
  private final List<CalistisCommand> commands = new ArrayList<>();

  public CalistisCommandManager(Calistis calistis) {
    this.calistis = calistis;
    this.registerCommands();
  }

  private void registerCommands() {
    this.commands.add(new AboutCommand());
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (! (commandSender instanceof Player)) {
      commandSender.sendMessage(" ");
      return false;
    }
    Player player = (Player) commandSender;
    if (strings.length == 0) {
      player.sendMessage(" ");
      return false;
    }
    this.commands.forEach(cmd -> {
      if (!player.hasPermission(cmd.getPermission())){
        player.sendMessage(" ");
        return;
      }
      if (strings[0].equalsIgnoreCase(cmd.getName())) {
        this.calistis.getServer()
                .getScheduler()
                .scheduleDelayedTask(() -> {cmd.perform(player, strings);}, 1, true);
      }
  });
    return false;
  }

  public Calistis getCalistis() {
    return calistis;
  }

  public List<CalistisCommand> getCommands() {
    return commands;
  }
}
