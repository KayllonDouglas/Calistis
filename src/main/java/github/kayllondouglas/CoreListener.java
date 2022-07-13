package github.kayllondouglas;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerAsyncPreLoginEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerLocallyInitializedEvent;
import cn.nukkit.event.player.PlayerPreLoginEvent;

public class CoreListener implements Listener {

  public void onLogin(PlayerAsyncPreLoginEvent event) {

  }

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
  }

  @EventHandler
  public void onInitialize(PlayerLocallyInitializedEvent event) {
    Player player = event.getPlayer();
  }

}
