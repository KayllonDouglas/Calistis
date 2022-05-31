package team.calistis;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.player.PlayerLoginEvent;
import team.calistis.economy.BankAccount;
import team.calistis.forms.FormScreen;

public class CalistisListener implements Listener {

  private Calistis core;

  public CalistisListener(Calistis core) {
    this.core = core;
  }

  @EventHandler
  public void loadData(PlayerLoginEvent event) {
    Player player = event.getPlayer();
    if (!this.core.getBankManager().hasBank(player)) {
      this.core.getBankManager().createBank(player, new BankAccount(
          BankAccount.DEFAULT_MONEY_VALUE,
          BankAccount.DEFAULT_CASH_VALUE,
          BankAccount.DEFAULT_MOBCOINS_VALUE,
          BankAccount.DEFAULT_SHARDS_VALUE));
    }
  }

  @EventHandler
  public void onFormResponse(PlayerFormRespondedEvent event) {
    if (!(event.getWindow() instanceof FormScreen)) return;
    if (event.wasClosed()) ((FormScreen)event.getWindow()).onClose(event.getPlayer());
    if (event.getResponse() == null) return;
    ((FormScreen)event.getWindow()).onResponse(event);
  }

  public Calistis getCore() {
    return core;
  }

}
