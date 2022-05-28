package team.calistis.command.economy.subcommand;

import cn.nukkit.command.CommandSender;
import team.calistis.command.utils.SubCommand;

public class SeeMoneySubCommand extends SubCommand {

  public SeeMoneySubCommand() {
    super("see", "See your or others money", new String[]{"s"});
  }

  @Override
  public void execute(CommandSender sender, String label, String[] args) {
  }

}
