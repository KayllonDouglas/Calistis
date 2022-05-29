package team.calistis.command;

import java.util.HashSet;
import java.util.Set;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;

public class EconomyCommandController implements CommandExecutor {

  public static Set<CoreCommand> commands = new HashSet<>();

  static {

  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player))
      return false;
    Player p = (Player) sender;
    if (args.length < 0) {
      commands.forEach(
          cm -> p.sendMessage(" §6§l»§r §7Utilize §6/" + cm.getName() + "§7, sobre: §6" + cm.getDescription()));
      return false;
    }
    commands.forEach(cm -> {
      if (args[0].equalsIgnoreCase(cm.getName())) {
        cm.dispatch(p, args);
      }
    });
    return false;
  }

}
