package team.calistis.manager.command;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import team.calistis.Calistis;
import team.calistis.command.faction.CreateFactionCommand;
import team.calistis.components.CalistisCommand;

public class FactionCommandManager implements CommandExecutor {

  private final Calistis calistis;
  private final List<CalistisCommand> allCommands = new ArrayList<>();

  public FactionCommandManager(Calistis calistis) {
    this.calistis = calistis;
    this.registerCommands();
  }

  private void registerCommands() {
    this.allCommands.add(new CreateFactionCommand());
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("§cThis command is not allowed here.");
      return false;
    }
    Player player = (Player) sender;
    if (args.length <= 0) {
      this.sendHelpMessage(player);
      return false;
    }
    this.allCommands.forEach(cm -> {
      if (!player.hasPermission(cm.getPermission())) {
        player.sendMessage(" §4§l»§r §cYou dont have permission to perform this action.");
        return;
      }
      if (args[0].equalsIgnoreCase(cm.getName())) {
        this.calistis
            .getServer()
            .getScheduler()
            .scheduleDelayedTask(() -> {
              cm.perform(player, args);
            }, 1);
      }
    });
    return true;
  }

  public void sendHelpMessage(Player player) {
    player.sendMessage(" ");
    this.allCommands.forEach(cm -> {
      player.sendMessage(" §4§l»§r §7Usage: §7/§cf §7" + cm.getName() + " §c- §7" + cm.getDescription() + ".");
    });
    player.sendMessage(" ");
  }

  public Calistis getCalistis() {
    return calistis;
  }

  public List<CalistisCommand> getAllCommands() {
    return allCommands;
  }

}
