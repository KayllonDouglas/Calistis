package team.calistis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import cn.nukkit.event.player.PlayerChatEvent;
import team.calistis.faction.Faction;

public class CoreManager {
  
  private static Map<UUID, Consumer<PlayerChatEvent>> inputMap = new HashMap<>();
  private static Map<String, Faction> factionsMap = new HashMap<>();

  private CoreManager() {} 

  public static Map<UUID, Consumer<PlayerChatEvent>> getInputMap() {
      return inputMap;
  }

  public static Map<String, Faction> getFactionsMap() {
      return factionsMap;
  }

}
