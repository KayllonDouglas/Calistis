package team.calistis.commands.types;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import team.calistis.commands.CoreCommand;
import team.calistis.forms.bank.BankForm;

public class BankCommand extends CoreCommand {

	public BankCommand() {
		super("banco", "Comando principal das funcoes do banco.", "/banco ajuda", new String[]{"b"});
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
	  if (!(sender instanceof Player)) {
	    sender.sendMessage("§4Este comando só pode ser usado in-game.");
	    return false;
	  }
	  Player player = (Player) sender;
	  if (!player.hasPermission("calistis.command.bank")) {
	    player.sendMessage("§4Voce nao tem permissao para usar este comando.");
	    return false;
	  }
	  player.showFormWindow(new BankForm());
		return true;
	}
  
}
