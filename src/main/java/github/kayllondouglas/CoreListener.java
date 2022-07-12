package github.kayllondouglas;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerPreLoginEvent;
import github.kayllondouglas.api.API;
import github.kayllondouglas.profile.Profile;

public class CoreListener implements Listener {

  @EventHandler
  public void onLogin(PlayerPreLoginEvent event) {
    if (!API.getProfiles().containsKey(event.getPlayer().getUniqueId())) {
      API.getProfiles().put(event.getPlayer().getUniqueId(), new Profile(null, null));
      return;
    }
  }
  
}
