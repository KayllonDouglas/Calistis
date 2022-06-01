package team.calistis.utils.form;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;

public interface FormScreen {

  void onResponse(PlayerFormRespondedEvent event);

  void onClose(Player player);
  
}
