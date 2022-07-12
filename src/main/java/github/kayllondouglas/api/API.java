package github.kayllondouglas.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import github.kayllondouglas.CalistisPlayer;
import github.kayllondouglas.faction.Faction;

public class API {

  private static final Map<String, Faction> factions = new HashMap<>();
  private static final Map<UUID, CalistisPlayer> players = new HashMap<>();

  /**
   * @return the factions
   */
  public static Map<String, Faction> getFactions() {
      return factions;
  }

  /**
   * @return the players
   */
  public static Map<UUID, CalistisPlayer> getPlayers() {
      return players;
  }
  
}
