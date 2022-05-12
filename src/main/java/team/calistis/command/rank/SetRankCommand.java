package team.calistis.command.rank;

import cn.nukkit.Player;
import cn.nukkit.plugin.Plugin;
import team.calistis.Calistis;
import team.calistis.command.CalistisCommand;

import java.util.Optional;

public class SetRankCommand implements CalistisCommand {

  @Override
  public String getName() {
    return "set";
  }

  @Override
  public String getDescription() {
    return "Set a rank";
  }

  @Override
  public String getPermission() {
    return "calistis.command.set-rank";
  }

  @Override
  public void perform(Player player, String[] args) {
    if (args.length <= 1) {
      player.sendMessage(" §4>§r §cYou don't provided a valid player.");
      return;
    }
    Optional<Player> target = Optional.ofNullable(Calistis.getInstance().getServer().getPlayer(args[1]));
    if (target.isEmpty()) {
      player.sendMessage(" §4>§r §cThis player is offline or don't exists.");
      return;
    }
    if (args.length <= 2) {
      player.sendMessage(" §4>§r §cYou don't provided a valid rank.");
      return;
    }
    player.sendMessage("");
  }

}
