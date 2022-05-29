package team.calistis.command;

import cn.nukkit.Player;

public interface CoreCommand {

  String getName();

  String getPermission();

  String getDescription();

  void dispatch(Player player, String[] args);
  
}
