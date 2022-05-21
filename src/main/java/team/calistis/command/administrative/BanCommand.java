/*
 * APACHEThe APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Author. All rights reserved.
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
package team.calistis.command.administrative;

import cn.nukkit.Player;
import team.calistis.Calistis;
import team.calistis.CalistisSystem;
import team.calistis.administrative.components.BanComponent;
import team.calistis.command.CoreCommand;

public class BanCommand implements CoreCommand {

  @Override
  public String getName() {
    return "ban";
  }

  @Override
  public String getPermission() {
    return "calistis.administrative.ban-command";
  }

  @Override
  public String getDescription() {
    return "Use para efetuar o banimento de um jogador que jogabde forma irregular";
  }

  // /adm? system? ban <player> <reason> <isPermanent?>
  @Override
  public void dispatch(Player executor, String[] args) {
    if (args.length <= 1) {
      executor.sendMessage(" §4» §7Uso indevido, utilize §4/" + this.getName() + "§7.");
      return;
    }
    if (args.length <= 2) {
      executor.sendMessage(" §4» §7Você §4não especificou §7o nome de um jogador.");
      return;
    }
    Player target = Calistis.getInstance().getServer().getPlayer(args[2]);
    if (args.length <= 3) {
      executor.sendMessage(" §4» §7Você §4não especificou §7a razão do banimento.");
      return;
    }
    String reason = args[3];
    if (args.length <= 4) {
      return;
    }
    if (target == null) {
      executor.sendMessage(" §4» §7Este jogador §4não existe §7ou §4esta offline§7.");
      return;
    }
    if (CalistisSystem.getBannedPlayers().containsKey(target.getUniqueId())) {
      executor.sendMessage(" §4» §7Este jogador ja esta banido!");
      return;
    }
    CalistisSystem.getBannedPlayers().put(target.getUniqueId(), new BanComponent(reason, banType, banDate));
  }

}
