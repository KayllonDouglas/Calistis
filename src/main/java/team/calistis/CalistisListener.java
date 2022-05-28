package team.calistis;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerLoginEvent;
import lombok.Getter;

@Getter
public class CalistisListener implements Listener {

  private final Calistis calistis;

  public CalistisListener(Calistis calistis) {
    this.calistis = calistis;
  }

  @EventHandler
  public void onLogin(PlayerLoginEvent event) {
    Player player = event.getPlayer();
  }

}
