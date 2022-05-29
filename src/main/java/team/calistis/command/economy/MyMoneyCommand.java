package team.calistis.command.economy;

import cn.nukkit.Player;
import team.calistis.command.CoreCommand;
import team.calistis.system.EconomySystem;
import team.calistis.zcore.utils.TitleUtils;

public class MyMoneyCommand implements CoreCommand {

  @Override
  public String getName() {
    return "mymoney";
  }

  @Override
  public String getPermission() {
    return "calistis.economy.mymoney";
  }

  @Override
  public String getDescription() {
    return "See your money";
  }

  @Override
  public void dispatch(Player player, String[] args) {
    player.sendMessage("§7Seu dinheiro atual é §a" + EconomySystem.getMoney(player) + "§7.");
    TitleUtils.addActionBarMessage(player, "§7Seu dinheiro atual é §a" + EconomySystem.getMoney(player) + "§7.");
  }

}