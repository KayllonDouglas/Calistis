package github.kayllondouglas;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerLocallyInitializedEvent;
import cn.nukkit.event.player.PlayerPreLoginEvent;

import github.kayllondouglas.faction.player.FactionPlayer;

public class CoreListener implements Listener {

  @EventHandler
  public void onLogin(PlayerPreLoginEvent event) {
    Player player = event.getPlayer();
    if (!CoreManager.getPlayers().containsKey(player.getUniqueId())) {
      CoreManager.getPlayers().put(player.getUniqueId(), new FactionPlayer(null, null, 0, 0, 0));
    }
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    event.setJoinMessage(" §l§a»§r §7" + event.getPlayer().getNameTag() + " §a§l+§r");
  }

  @EventHandler
  public void onInitialize(PlayerLocallyInitializedEvent event) {
    Player player = event.getPlayer();
    Core.getInstance()
        .getServer()
        .getScheduler()
        .scheduleDelayedTask(Core.getInstance(), () -> {
          if (CoreManager.getPlayers().get(player.getUniqueId()).getFaction() == null) {
            player.sendMessage("");
          }
          player.sendTitle("§7§l• §6Calistis §7•§r",
              "§7Welcome §6§l" + player.getNameTag() + "§r§7, enjoy the gameplay.", 60, 60, 60);
        }, 20);
  }

}
