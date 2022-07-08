package team.calistis.command.types;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import team.calistis.command.Command;
import team.calistis.command.types.subcommands.CreateFactionSubCommand;

public class FactionCommand extends Command {

  public FactionCommand() {
    super("f");
    this.registerSubCommand("create", new CreateFactionSubCommand());
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!sender.isPlayer()) return false;
    Player player = (Player) sender;
    if (!player.hasPermission("calistis.command.faction")) {
      player.sendMessage("generic-no-permission");
      return false;
    }
    if (args.length <= 0) {
      player.sendMessage("generic-no-args");
      return false;
    }
    if (this.getSubCommand(args[0]) != null) {
      this.getSubCommand(args[0]).execute(sender, label, args);
      return true;
    }
    return true;
  }

}
