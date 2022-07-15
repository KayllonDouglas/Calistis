package github.kayllondouglas.api;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import github.kayllondouglas.faction.Faction;
import github.kayllondouglas.faction.FactionPlayer;

public class API {

  private static final Set<Faction> factions = new HashSet<>();
  private static final Set<FactionPlayer> players = new HashSet<>();

  /**
   * @param name
   * @return
   */
  public static Faction getFaction(String name) {
    return factions.parallelStream()
        .filter(f -> f.getName()
            .equalsIgnoreCase(name))
        .findFirst()
        .orElse(null);
  }

  /**
   * @param uuid
   * @return
   */
  public static FactionPlayer getPlayer(UUID uuid) {
    return players.parallelStream()
        .filter(p -> p.getUniqueId()
            .equals(uuid))
        .findFirst()
        .orElse(null);
  }

  public static Set<Faction> getFactions() {
    return factions;
  }

  public static Set<FactionPlayer> getPlayers() {
    return players;
  }

}
