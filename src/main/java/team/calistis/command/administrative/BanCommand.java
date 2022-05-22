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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import cn.nukkit.Player;
import lombok.SneakyThrows;
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

  @SneakyThrows
  @Override
  public void dispatch(Player executor, String[] args) {
    if (args.length <= 1) {
      executor.sendMessage(" §4» §7Você §4não especificou §7o nome de um jogador.");
      return;
    }
    if (args.length <= 2) {
      executor.sendMessage(" §4» §7Você §4não especificou §7a razão do banimento.");
      return;
    }
    Player target = Calistis.getInstance().getServer().getPlayer(args[1]);
    if (target == null) {
      executor.sendMessage(" §4» §7Este jogador §4não existe §7ou §4esta offline§7.");
      return;
    }
    String reason = args[2];
    if (CalistisSystem.getBannedPlayers().containsKey(target.getUniqueId())) {
      executor.sendMessage(" §4» §7Este jogador ja esta banido!");
      return;
    }
    CalistisSystem.getBannedPlayers().put(target.getUniqueId(), new BanComponent(reason, new Date()));
    Calistis.getInstance().getServer().broadcastMessage(" §4» §7O jogador §d" + target.getNameTag() + " §7foi banido do servidor.");
    Calistis.getInstance().getServer().broadcastMessage(" §4» §7Motivo do banimento: §d" + reason + "");
    SimpleDateFormat format = new SimpleDateFormat("EEEEE, dd MMMMM yyyy, HH:mm:ss", new Locale("pt","BR"));
    format.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
    String date = format.format(CalistisSystem.getBannedPlayers().get(target.getUniqueId()).getBanDate());
    target.close("", String.format("§4Você foi banido permanentemente deste servidor\n§7MOTIVO\n\n§4%s\n\n§7Data do banimento: §4%s§7.", reason, date));
  }

}
