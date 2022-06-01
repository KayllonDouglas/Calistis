package team.calistis;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.player.PlayerLoginEvent;
import team.calistis.components.economy.PlayerBank;
import team.calistis.system.general.EconomySystem;
import team.calistis.utils.form.FormScreen;

public class CoreListener implements Listener {

  private Core core;

  public CoreListener(Core core) {
    this.core = core;
  }

  public void loadData(PlayerLoginEvent event) {
    if (!EconomySystem.hasBank(event.getPlayer()))
      EconomySystem.createBank(event.getPlayer(), new PlayerBank(0));
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
