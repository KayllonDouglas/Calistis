package team.calistis.command.core;

import cn.nukkit.Player;

public interface CalistisCommand {

  String getName();

  String getDescription();

  String getPermission();

  void perform(Player player, String[] arguments);

}
