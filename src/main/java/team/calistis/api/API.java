package team.calistis.api;

import cn.nukkit.event.player.PlayerChatEvent;
import team.calistis.faction.Faction;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class API {

  private static final Map<UUID, Consumer<PlayerChatEvent>> inputMap = new HashMap<>();
  private static final Map<String, Faction> factionsMap = new HashMap<>();

  public static Map<String, Faction> getFactionsMap() {
    return factionsMap;
  }

  public static Map<UUID, Consumer<PlayerChatEvent>> getInputMap() {
    return inputMap;
  }

}
