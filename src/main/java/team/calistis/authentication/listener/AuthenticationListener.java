package team.calistis.authentication.listener;

import java.util.Date;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.inventory.InventoryOpenEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.inventory.PlayerInventory;
import team.calistis.Calistis;
import team.calistis.authentication.AuthenticationManager;
import team.calistis.authentication.PlayerRegistrator;

public class AuthenticationListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    if (!AuthenticationManager.isPlayerRegistrated(player)) {
      AuthenticationManager.registerPlayer(player, new PlayerRegistrator(null, new Date()));
      AuthenticationManager.getConfiguration().getStringList("on-register-messages").forEach(m -> {
        player.sendMessage(String.format(m, player.getNameTag()));
      });
      return;
    }
    AuthenticationManager.getConfiguration().getStringList("on-login-messages").forEach(m -> {
      player.sendMessage(String.format(m, player.getNameTag()));
    });
  }

  @EventHandler
  public void onMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    if (!AuthenticationManager.isPlayerAuthenticated(player)) {
      player.sendPopup("§6Você não pode efetuar esta ação no momento.");
      event.setCancelled(true);
      return;
    }
  }

  @EventHandler
  public void onInventoryOpen(InventoryOpenEvent event) {
    Player player = event.getPlayer();
    if (!AuthenticationManager.isPlayerAuthenticated(player)) {
      if (event.getInventory() instanceof PlayerInventory) {
        Calistis.getInstance().getServer().getScheduler().scheduleDelayedTask(() -> {
          event.getInventory().close(player);
          event.setCancelled(true);
          player.sendMessage("§6Você não pode efetuar esta ação no momento.");
        }, 1);
        return;
      }
    }
  }

}
