package team.calistis.utils;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.SetTitlePacket;

public final class TitleUtils {

  /**
   * Send a title message above on the player hotbar. 
   * @param player 
   * @param message 
   */
  public static void addActionBarMessage(Player player, String message) {
    sendTitleMessage(player, message, SetTitlePacket.TYPE_ACTION_BAR);
  }

  /**
   * Send a title message on the player screen.
   * @param player
   * @param title
   * @param subtitle
   * @param fadeInTime
   * @param stayTime
   * @param fadeOutTime
   */
  public static void addTitle(Player player, String title, String subtitle, int fadeInTime, int stayTime, int fadeOutTime) {
    setTitleDuration(player, fadeInTime, stayTime, fadeOutTime);
    if (subtitle != "") sendTitleMessage(player, subtitle, SetTitlePacket.TYPE_SUBTITLE);
    sendTitleMessage(player, title, SetTitlePacket.TYPE_TITLE);
  }

  /**
   * Remove all title messages from the player screen.
   * @param player
   */
  public static void removeTitles(Player player) {
    SetTitlePacket pk = new SetTitlePacket();
    pk.type = SetTitlePacket.TYPE_CLEAR;
    player.dataPacket(pk);
  }

  private static void setTitleDuration(Player player, int fadeInTime, int stayTime, int fadeOutTime) {
    if (fadeInTime >= 0 || stayTime >= 0 || fadeOutTime >= 0) {
      SetTitlePacket pk = new SetTitlePacket();
      pk.type = SetTitlePacket.TYPE_ANIMATION_TIMES;
      pk.fadeInTime = fadeInTime;
      pk.stayTime = stayTime;
      pk.fadeOutTime = fadeOutTime;
      player.dataPacket(pk);
    }
  }

  private static void sendTitleMessage(Player player, String title, int type) {
    SetTitlePacket pk = new SetTitlePacket();
    pk.text = title;
    pk.type = type;
    player.dataPacket(pk);
  }

}
