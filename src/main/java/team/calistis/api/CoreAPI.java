package team.calistis.api;

import cn.nukkit.event.player.PlayerChatEvent;
import team.calistis.Core;
import team.calistis.CoreListener;
import team.calistis.command.types.FactionCommand;
import team.calistis.faction.Faction;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class CoreAPI {

  private static final Map<UUID, Consumer<PlayerChatEvent>> inputMap = new HashMap<>();
  private static final Map<String, Faction> factionsMap = new HashMap<>();

  public static boolean startApi() {
    Core.getInstance().getServer().getPluginManager().registerEvents(new CoreListener(), Core.getInstance());
    Core.getInstance().getServer().getCommandMap().register("f", new FactionCommand("f", "Default Faction Command."));
    return true;
  }

  public static Map<UUID, Consumer<PlayerChatEvent>> getInputMap() {
    return inputMap;
  }

  public static Map<String, Faction> getFactionsMap() {
    return factionsMap;
  }

}
