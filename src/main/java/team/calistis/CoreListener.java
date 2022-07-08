package team.calistis;

import java.util.function.Consumer;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerLocallyInitializedEvent;
import cn.nukkit.event.player.PlayerPreLoginEvent;

import team.calistis.api.Awaiter;
import team.calistis.tasks.player.OnPlayerJoinTask;

public class CoreListener implements Listener {

  @EventHandler
  public void onPreLogin(PlayerPreLoginEvent event) {
    Player player = event.getPlayer();
    if (!Awaiter.getPlayersMap().containsKey(player.getUniqueId())) {
      Awaiter.getPlayersMap().put(player.getUniqueId(), new CorePlayer(0, 0, null, null));
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

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    Consumer<PlayerInteractEvent> consumer = Awaiter.getAwaitingInteractMap().get(player.getUniqueId());
    if (consumer == null)
      return;
    consumer.accept(event);
  }

  @EventHandler
  public void onPlayerChat(PlayerChatEvent event) {
    Player player = event.getPlayer();
    Consumer<PlayerChatEvent> consumer = Awaiter.getAwaitingChatInputMap().get(player.getUniqueId());
    if (consumer == null)
      return;
    consumer.accept(event);
  }

}
