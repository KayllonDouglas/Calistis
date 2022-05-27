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
package team.calistis.economy.command;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import team.calistis.command.Command;
import team.calistis.command.SubCommand;
import team.calistis.economy.command.subcommand.SeeMoneySubCommand;

public class MoneyCommand extends Command {

	public MoneyCommand() {
		super("money", "Default Money Command", "/money", new String[] { "m" });
		this.registerSubcommand(new SeeMoneySubCommand());
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player player = (Player) sender;
		if (args.length <= 0) {
			player.sendMessage("use /money or /m");
			return false;
		}
		SubCommand scmd = this.getSubCommand(args[0]);
		if (scmd != null) {
			scmd.execute(player, label, args);
			return true;
		}
		return false;
	}

}
