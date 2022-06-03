package team.calistis;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.player.PlayerPreLoginEvent;
import team.calistis.economy.EconomyManager;
import team.calistis.economy.PlayerEconomy;
import team.calistis.zcore.form.FormScreen;

public class CoreListener implements Listener {

  @EventHandler
  public void onFirstLogin(PlayerPreLoginEvent event) {
    if (!EconomyManager.hasEconomy(event.getPlayer()))
      EconomyManager.createEconomy(event.getPlayer(),
          new PlayerEconomy(PlayerEconomy.DEFAULT_MONEY_VALUE, PlayerEconomy.DEFAULT_CASH_VALUE));
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

}
