package github.kayllondouglas;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerLocallyInitializedEvent;
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

  @EventHandler
  public void onInitialize(PlayerLocallyInitializedEvent event) {
    Core.getInstance()
        .getServer()
        .getScheduler()
        .scheduleDelayedTask(Core.getInstance(), () -> {
          if (API.getProfiles().get(event.getPlayer().getUniqueId()).getFaction() == null) {
            event.getPlayer().sendMessage("§6§l»§r §7It looks like you are not a leader/member of a faction, create or join one that is public.");
          }
          event.getPlayer().sendTitle(
              "§7· §6§lCalistis§r §7·",
              "§6· §7Welcome §6" + event.getPlayer().getNameTag() + "§7, enjoy the gameplay §6·",
              60, 60, 60);
        }, 20);
  }

  @EventHandler
  public void onChat(PlayerChatEvent event) {
    if (API.getConversations().containsKey(event.getPlayer().getUniqueId())) {
      API.getConversations().get(event.getPlayer().getUniqueId()).accept(event);
      return;
    }
  }
  
}
