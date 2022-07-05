package team.calistis;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerLocallyInitializedEvent;
import cn.nukkit.event.player.PlayerPreLoginEvent;
import team.calistis.api.API;
import team.calistis.tasks.player.OnPlayerJoinTask;

public class CoreListener implements Listener {

  @EventHandler
  public void onPreLogin(PlayerPreLoginEvent event) {
    Player player = event.getPlayer();
    if (!API.getPlayersMap().containsKey(player.getUniqueId())) {
      API.getPlayersMap().put(player.getUniqueId(), new CorePlayer(0, 0, null, null));
      return;
    }
  }

  @EventHandler
  public void onPlayerInitialize(PlayerLocallyInitializedEvent event) {
    Player player = event.getPlayer();

    Server.getInstance()
        .broadcastMessage(" §l§a»§r §7" + player.getNameTag() + " §a+");

    Server.getInstance()
        .getScheduler()
        .scheduleDelayedTask(new OnPlayerJoinTask(Core.getInstance(), player), 30);

  }

}
