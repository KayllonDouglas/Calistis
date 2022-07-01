package team.calistis;

import java.util.function.Consumer;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;

public class CoreListener implements Listener {

  @EventHandler
  public void onChatInput(PlayerChatEvent event) {
    Consumer<PlayerChatEvent> consumer = CoreManager.getInputMap().get(event.getPlayer().getUniqueId());
    if (consumer.equals(null))
      consumer.accept(event);
    return;
  }

}
