package team.calistis.command.types;

import cn.nukkit.command.CommandSender;
import team.calistis.command.Command;

public class FactionCommand extends Command {

  public FactionCommand() {
    super("f",
        "Default factions command",
        "/f",
        new String[] { "fac", "faction", "factions" });
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    return false;
  }

}
