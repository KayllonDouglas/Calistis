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
package team.calistis.command;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.command.CommandSender;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public abstract class Command extends cn.nukkit.command.Command {

	private final List<SubCommand> subCommands = new ArrayList<>();

	public Command(String name, String description, String usageMessage, String[] aliases) {
		super(name, description, usageMessage, aliases);
	}

	@SneakyThrows
	public boolean registerSubcommand(SubCommand subCommand) {
		if (this.subCommands.contains(subCommand))
			throw new CommandException("SubCommand" + subCommand.getName() + " already exists.");
		return this.subCommands.add(subCommand);
	}

	public SubCommand getSubCommand(String name) {
		for (SubCommand sub : this.subCommands)
			if (sub.getName().equalsIgnoreCase(name))
				return sub;
		return null;
	}

	public abstract boolean execute(CommandSender sender, String label, String[] args);

}
