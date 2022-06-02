package team.calistis;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import team.calistis.zcore.utils.form.FormScreen;

public class CoreListener implements Listener {

  private final Core core;

  public CoreListener(Core core) {
    this.core = core;
  }

  @EventHandler
  public void onFormResponse(PlayerFormRespondedEvent event) {
    if (!(event.getWindow() instanceof FormScreen))
      return;
    if (event.wasClosed())
      ((FormScreen) event.getWindow()).onClose(event.getPlayer());
    if (event.getResponse() == null)
      return;
    ((FormScreen) event.getWindow()).onResponse(event);
  }

  public Core getCore() {
    return core;
  }

}
