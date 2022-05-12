package team.calistis;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import team.calistis.manager.components.Group;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CalistisListener implements Listener {

  private final Calistis calistis;

  public CalistisListener(Calistis calistis) {
    this.calistis = calistis;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
  }

  @EventHandler
  public void onChat(PlayerChatEvent e) {
    e.setCancelled(true);
  }

  public Calistis getCalistis() {
    return this.calistis;
  }

}
