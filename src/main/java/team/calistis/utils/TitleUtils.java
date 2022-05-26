/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Constanze. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
