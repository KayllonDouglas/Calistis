package team.calistis.command.types.subcommands;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.player.PlayerInteractEvent;
import team.calistis.api.API;
import team.calistis.command.SubCommand;

public class CreateFactionSubCommand extends SubCommand {

  public CreateFactionSubCommand() {
    super("calistis.command.create-faction");
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!sender.isPlayer())
      return false;
    Player player = (Player) sender;
    player.sendMessage(" §d§l»§r §7Enter the name to be applied to your faction, §cuse alphanumeric characters only§7.");
    API.getAwaitingChatInputMap().put(player.getUniqueId(), cev -> {
      cev.setCancelled(true);
      String name = cev.getMessage();
      API.getAwaitingChatInputMap().remove(player.getUniqueId());
      player.sendMessage(" §6§l»§r §7You choosed §6" + name + "§7 as your faction name.");
      player.sendMessage(" §d§l»§r §7Tap where you want your faction flag to stand.");
      API.getAwaitingInteractMap().put(player.getUniqueId(), iev -> {
        if (iev.getAction().equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {

          API.getAwaitingInteractMap().remove(player.getUniqueId());
          return;
        }
      });
    });
    return true;
  }

}
