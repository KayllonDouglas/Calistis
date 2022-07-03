package team.calistis.api;

import cn.nukkit.event.player.PlayerChatEvent;
import team.calistis.faction.Faction;
import team.calistis.player.CorePlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class API {

  private static final Map<UUID, Consumer<PlayerChatEvent>> inputsMap = new HashMap<>();
  private static final Map<UUID, CorePlayer> playersMap = new HashMap<>();
  private static final Map<String, Faction> factionsMap = new HashMap<>();

  public static Map<UUID, Consumer<PlayerChatEvent>> getInputsMap() {
    return inputsMap;
  }

  public static Map<UUID, CorePlayer> getPlayersMap() {
      return playersMap;
  }

  public static Map<String, Faction> getFactionsMap() {
      return factionsMap;
  }

}
