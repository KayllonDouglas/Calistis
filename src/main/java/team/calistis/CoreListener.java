package team.calistis;

import java.util.function.Consumer;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import team.calistis.api.CoreAPI;

public class CoreListener implements Listener {

  @EventHandler
  public void onChatInput(PlayerChatEvent event) {
    Consumer<PlayerChatEvent> consumer = CoreAPI.getInputMap().get(event.getPlayer().getUniqueId());
    consumer.accept(event);
  }

}
