package team.calistis.forms.bank;

import java.util.Arrays;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementDropdown;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.window.FormWindowCustom;
import team.calistis.Calistis;
import team.calistis.forms.FormScreen;

public class PaySomeoneForm extends FormWindowCustom implements FormScreen {


	public PaySomeoneForm() {
		super("Pagamento");
		for (Player p : Calistis.getInstance().getServer().getOnlinePlayers().values()) {
		  this.addElement(new ElementDropdown("Selecione o jogador que sera pago", Arrays.asList(p.getName())));
		}
		this.addElement(new ElementInput("Quantia a ser paga"));
	}

	@Override
	public void onResponse(PlayerFormRespondedEvent event) {
	}

	@Override
	public void onClose(Player player) {
		player.showFormWindow(new BankForm());
	}
  
}
