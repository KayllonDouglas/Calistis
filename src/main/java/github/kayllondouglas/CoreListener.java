package github.kayllondouglas;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerLocallyInitializedEvent;

public class CoreListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
  }

  @EventHandler
  public void onInitialize(PlayerLocallyInitializedEvent event) {
    Player player = event.getPlayer();
  }

}
