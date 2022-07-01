package team.calistis.command.types;

import cn.nukkit.command.CommandSender;
import team.calistis.command.Command;

public class FactionCommand extends Command {

  public FactionCommand(String name, String description) {
    super(name, description);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    return false;
  }

}
