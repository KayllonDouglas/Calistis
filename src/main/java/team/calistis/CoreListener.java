package team.calistis;

import java.util.function.Consumer;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import team.calistis.api.API;

public class CoreListener implements Listener {

  @EventHandler
  public void onChatInput(PlayerChatEvent event) {
    Consumer<PlayerChatEvent> consumer = API.getInputMap().get(event.getPlayer().getUniqueId());
    if (consumer == null) return;
    consumer.accept(event);
  }

}
