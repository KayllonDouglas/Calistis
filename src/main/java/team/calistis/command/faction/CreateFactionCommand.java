package team.calistis.command.faction;

import cn.nukkit.Player;
import team.calistis.components.CalistisCommand;

public class CreateFactionCommand implements CalistisCommand {

	@Override
	public String getName() {
		return "create";
	}

	@Override
	public String getDescription() {
		return "Create your brand new Faction";
	}

	@Override
	public String getPermission() {
		return "calistis.command.create-faction";
	}

	@Override
	public void perform(Player player, String[] args) {
		player.sendMessage(" §4§l»§r §ajust testing omfg!");
	}
  
}
