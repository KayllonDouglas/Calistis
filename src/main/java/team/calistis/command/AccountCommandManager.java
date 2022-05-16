package team.calistis.command;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import team.calistis.Calistis;
import team.calistis.command.account.AuthenticateAccountCommand;
import team.calistis.command.account.RegisterAccountCommand;

public class AccountCommandManager implements CommandExecutor {

  private final List<CalistisCommand> calistisCommands = new ArrayList<>();

  public AccountCommandManager() {
    this.calistisCommands.add(new RegisterAccountCommand());
    this.calistisCommands.add(new AuthenticateAccountCommand());
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(" \n§c» §7Este comando §cnão pode ser efetuado §7no console! \n");
      return false;
    }
    Player player = (Player) sender;
    if (args.length <= 0) {
      this.sendHelpMessage(player);
      return false;
    }
    this.calistisCommands.forEach(cm -> {
      if (!player.hasPermission(cm.getPermission())) {
        player.sendMessage(" \n§c» §7Você §cnão tem permissão §7para executar este comando.\n");
        return;
      }
      if (args[0].equalsIgnoreCase(cm.getName())) {
        Calistis.getInstance().getServer().getScheduler().scheduleDelayedTask(() -> {
          cm.perform(player, args);
        }, 1);
      }
    });
    return true;
  }

  public void sendHelpMessage(Player player) {
    this.calistisCommands.forEach(cm -> {
      player.sendMessage(
          " \n§d» §7Uso: §d/conta <" + cm.getName() + ">§7, Descrição: §d" + cm.getDescription() + "§7.\n");
    });
  }

}
