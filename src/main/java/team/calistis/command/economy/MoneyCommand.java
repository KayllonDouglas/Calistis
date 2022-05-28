package team.calistis.command.economy;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import team.calistis.command.utils.Command;
import team.calistis.command.utils.SubCommand;
import team.calistis.command.economy.subcommand.SeeMoneySubCommand;

public class MoneyCommand extends Command {

	public MoneyCommand() {
		super("money", "Default Money Command", "/money", new String[] { "m" });
		this.registerSubcommand(new SeeMoneySubCommand());
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player player = (Player) sender;
		if (args.length <= 0) {
			player.sendMessage("use /money or /m");
			return false;
		}
		SubCommand scmd = this.getSubCommand(args[0]);
		if (scmd != null) {
			scmd.execute(player, label, args);
			return true;
		}
		return false;
	}

}
