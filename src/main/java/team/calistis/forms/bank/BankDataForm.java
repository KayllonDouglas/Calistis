package team.calistis.forms.bank;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;
import team.calistis.Calistis;
import team.calistis.forms.FormScreen;

public class BankDataForm extends FormWindowSimple implements FormScreen {

  public BankDataForm(Player player) {
    super("Seus dados estao descritos abaixo",
        "§a» §7Dinhero: §a" + Calistis.getInstance().getBankManager().getMoney(player) + "\n" +
        "§a» §7Cash: §a" + Calistis.getInstance().getBankManager().getCash(player) + "\n" +
        "§a» §7Mob-Coins: §a" + Calistis.getInstance().getBankManager().getMobCoins(player) + "\n" +
        "§a» §7Fragmentos: §a" + Calistis.getInstance().getBankManager().getShards(player));
  }

	@Override
	public void onResponse(PlayerFormRespondedEvent event) {
	}

	@Override
	public void onClose(Player player) {
	  player.showFormWindow(new BankForm());
	}
  
}
