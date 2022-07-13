package github.kayllondouglas;

import github.kayllondouglas.faction.Faction;
import github.kayllondouglas.faction.player.FactionPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CoreManager {

  private static final Map<String, Faction> factions = new HashMap<>();
  private static final Map<UUID, FactionPlayer> players = new HashMap<>();

  public static Map<String, Faction> getFactions() {
    return factions;
  }

  public static Map<UUID, FactionPlayer> getPlayers() {
    return players;
  }

}
