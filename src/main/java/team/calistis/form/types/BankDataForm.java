package team.calistis.form.types;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;
import team.calistis.form.BankForm;
import team.calistis.system.general.EconomySystem;
import team.calistis.utils.form.FormScreen;

public class BankDataForm extends FormWindowSimple implements FormScreen {

	public BankDataForm(Player player) {
		super("Seus dados bancarios", "\n\n" +
		    "§6» §7Sua quantia em dinheiro atual é: " + EconomySystem.getMoney(player));
	}

	@Override
	public void onResponse(PlayerFormRespondedEvent event) {
	}

	@Override
	public void onClose(Player player) {
		player.showFormWindow(new BankForm());
	}
  
}
