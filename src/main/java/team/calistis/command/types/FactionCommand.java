package team.calistis.command.types;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import lombok.extern.log4j.Log4j2;
import team.calistis.api.API;
import team.calistis.command.Command;

import java.util.Map;

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
    API.getFactionsMap().values().forEach(val -> {
      if (val == null) {
        ((Player)sender).sendMessage("no-factions");
        return;
      }
      if (!val.getMembers().containsKey(((Player)sender).getUniqueId())) {
        ((Player)sender).sendMessage("not in faction");
        return;
      }
      ((Player)sender).sendMessage("in faction");
    });
    return true;
  }

}
