package github.kayllondouglas;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerLoginEvent;
import github.kayllondouglas.api.API;
import github.kayllondouglas.faction.FactionPlayer;

public class CoreListener implements Listener {

  @EventHandler
  public void onLogin(final PlayerLoginEvent event) {
    Player player = event.getPlayer();
    if (API.getPlayer(player.getUniqueId()).getFaction() == null) {
      API.getPlayers().add(new FactionPlayer(player.getUniqueId(), 0, 0, 0, null));
    }
  }

}
