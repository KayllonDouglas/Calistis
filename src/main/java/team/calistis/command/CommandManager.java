/*
 * The APACHE License (APACHE)
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
package team.calistis.command;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import lombok.Getter;
import team.calistis.Calistis;
import team.calistis.command.administrative.BanCommand;

public class CommandManager implements CommandExecutor {

  @Getter
  private static List<CoreCommand> allCommands = new ArrayList<>();

  static {
    allCommands.add(new BanCommand());
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String labal, String[] args) {
    if (!(sender instanceof Player))
      return false;
    Player player = (Player) sender;
    if (args.length <= 0) {
      allCommands.forEach(cm -> {player.sendMessage(" §6» §7Uso: §6/" + cm.getName() + "§7, §6" + cm.getDescription() + "§7.");});
      return false;
    }
    allCommands.forEach(cmd -> {
      if (!player.hasPermission(cmd.getPermission())) {
        player.sendMessage(" §4» §7Você §4não tem a permissão necessaria §7para executar este comando.");
        return;
      }
      if (args[0].equalsIgnoreCase(cmd.getName())) {
        Calistis.getInstance().getServer().getScheduler().scheduleDelayedTask(() -> {
          cmd.dispatch(player, args);
        }, 1);
      }
    });
    return false;
  }

}
