package team.calistis.forms.bank;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import team.calistis.forms.FormScreen;

public class BankForm extends FormWindowSimple implements FormScreen {

	public BankForm() {
		super("Banco", "§aEscolha uma das opções abaixo.");
		this.addButton(new ElementButton("Dados bancarios"));
		this.addButton(new ElementButton("Pagar um jogador"));
	}

	@Override
	public void onResponse(PlayerFormRespondedEvent event) {
		if (this.getResponse().getClickedButton().getText().equalsIgnoreCase("Dados bancarios")) {
			event.getPlayer().showFormWindow(new BankDataForm(event.getPlayer()));
			return;
		}
		if (this.getResponse().getClickedButton().getText().equalsIgnoreCase("Pagar um jogador")) {
			event.getPlayer().showFormWindow(new PaySomeoneForm());
			return;
		}
	}

	@Override
	public void onClose(Player player) {

	}

}
