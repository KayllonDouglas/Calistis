package team.calistis.command.types;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import lombok.extern.log4j.Log4j2;
import team.calistis.api.API;
import team.calistis.command.Command;

@Log4j2
public class FactionCommand extends Command {

  public FactionCommand() {
    super("f",
        "Default factions command",
        "/f",
        new String[] { "fac", "faction", "factions" });
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!sender.isPlayer()) return false;
    Player player = (Player) sender;
    log.info("Abaixo do 'player'");
    API.getFactionsMap().values().forEach(fc -> {
      log.info("dentro do loop");
      if (!fc.getMembers().containsKey(player.getUniqueId())) {
        player.sendMessage("isn't in faction");
        return;
      }
      player.sendMessage("is in faction");
    });
    log.info("fora do loop");
    return true;
  }

}
