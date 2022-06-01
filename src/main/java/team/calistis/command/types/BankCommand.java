package team.calistis.command.types;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import team.calistis.command.CoreCommand;
import team.calistis.form.BankForm;

public class BankCommand extends CoreCommand {

	public BankCommand() {
		super("banco", "", "", new String[]{"b", "bnc"});
	}

	@Override
	public boolean execute(CommandSender s, String l, String[] a) {
		if (!(s instanceof Player)) return false;
		Player p = (Player) s;
		if (!p.hasPermission("core.command.bank")) {
			p.sendMessage("no-perm");
			return false;
		}
		p.showFormWindow(new BankForm());
		return true;
	}

}
