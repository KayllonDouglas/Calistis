package team.calistis.command.types;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import team.calistis.api.API;
import team.calistis.command.Command;
import team.calistis.faction.Faction;
import team.calistis.faction.FactionMember;

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
    API.getFactionsMap().values().forEach(fc -> {
      if (!fc.getMembers().containsKey(((Player)sender).getUniqueId())) {
        sender.sendMessage("isn't in faction");
        return;
      }
      sender.sendMessage("is in faction");
    });
    return false;
  }

}
