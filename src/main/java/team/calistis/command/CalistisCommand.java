package team.calistis.command;

import cn.nukkit.Player;

public interface CalistisCommand {

  String getName();

  String getDescription();

  String getPermission();

  void perform(Player player, String[] args);

}
