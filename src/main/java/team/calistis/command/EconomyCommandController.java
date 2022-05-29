package team.calistis.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.scheduler.Task;
import team.calistis.Calistis;
import team.calistis.command.economy.MyMoneyCommand;

import java.util.HashSet;
import java.util.Set;

public class EconomyCommandController implements CommandExecutor {

  private final Set<CoreCommand> commands = new HashSet<>();

  public EconomyCommandController() {
    commands.add(new MyMoneyCommand());
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player))
      return false;
    Player p = (Player) sender;
    if (args.length == 0) {
      commands.forEach(
              cm -> p.sendMessage(" §6§l»§r §7Utilize §6/" + cm.getName() + "§7, sobre: §6" + cm.getDescription()));
      return true;
    }
    Calistis.getInstance().getServer().getScheduler().scheduleDelayedTask(new Task() {
      @Override
      public void onRun(int i) {
        commands.forEach(cm -> {
          if (args[0].equalsIgnoreCase(cm.getName())) {
            cm.dispatch(p, args);
          }
        });
      }
    }, 20);
    return false;
  }

  public Set<CoreCommand> getCommands() {
    return commands;
  }

}
