package team.calistis.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import team.calistis.CorePlayer;
import team.calistis.faction.Faction;

public class Awaiter {
  
  private static final Map<UUID, Consumer<PlayerChatEvent>> awaitingChatInputMap = new HashMap<>();
  private static final Map<UUID, Consumer<PlayerInteractEvent>> awaitingInteractMap = new HashMap<>();

  private static final Map<UUID, CorePlayer> playersMap = new HashMap<>();
  private static final Map<String, Faction> factionsMap = new HashMap<>();

  public static Map<UUID, Consumer<PlayerChatEvent>> getAwaitingChatInputMap() {
      return awaitingChatInputMap;
  }

  public static Map<UUID, Consumer<PlayerInteractEvent>> getAwaitingInteractMap() {
      return awaitingInteractMap;
  }

  public static Map<UUID, CorePlayer> getPlayersMap() {
      return playersMap;
  }

  public static Map<String, Faction> getFactionsMap() {
      return factionsMap;
  }

}
