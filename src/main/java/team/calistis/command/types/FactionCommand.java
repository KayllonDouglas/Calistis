package team.calistis.command.types;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import lombok.extern.log4j.Log4j2;
import team.calistis.api.API;
import team.calistis.command.Command;
import team.calistis.faction.Faction;

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
    if (API.getFactionsMap().isEmpty()) {
      ((Player)sender).sendMessage("no-factions-in-map");
      return false;
    }
    API.getFactionsMap().values().forEach(val -> {
      ((Player)sender).sendMessage("vals" + val.getMembers().toString());
    });
    return true;
  }

}
