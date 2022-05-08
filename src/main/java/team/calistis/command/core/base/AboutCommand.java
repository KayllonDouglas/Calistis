package team.calistis.command.core.base;

import cn.nukkit.Player;
import team.calistis.command.core.CalistisCommand;

public class AboutCommand implements CalistisCommand {

  @Override
  public String getName() {
    return "about";
  }

  @Override
  public String getDescription() {
    return "Get the information about the Core.";
  }

  @Override
  public String getPermission() {
    return "calistis.command.about";
  }

  @Override
  public void perform(Player player, String[] arguments) {
    player.sendMessage(" ");
    player.sendMessage(" ");
    player.sendMessage(" ");
  }
}
