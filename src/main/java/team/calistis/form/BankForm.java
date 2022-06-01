package team.calistis.form;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;
import team.calistis.form.types.BankDataForm;
import team.calistis.utils.form.FormScreen;

public class BankForm extends FormWindowSimple implements FormScreen {

	public BankForm() {
		super("Banco", "");
		this.addButton(new ElementButton("Clique e veja seus dados bancarios.", new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, "https://img.icons8.com/ios/50/undefined/wallet--v1.png")));
	}

	@Override
	public void onResponse(PlayerFormRespondedEvent event) {
		if (this.getResponse().getClickedButton().getText().equalsIgnoreCase("Clique e veja seus dados bancarios.")) {
			event.getPlayer().showFormWindow(new BankDataForm(event.getPlayer()));
			return;
		}
	}

	@Override
	public void onClose(Player player) {
		
	}



}
