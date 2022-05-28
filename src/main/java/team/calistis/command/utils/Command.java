package team.calistis.command.utils;

import cn.nukkit.command.CommandSender;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

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
