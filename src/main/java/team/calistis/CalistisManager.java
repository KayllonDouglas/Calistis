package team.calistis;

import cn.nukkit.Player;
import team.calistis.components.Faction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CalistisManager {

  private final Calistis calistis;

  private final List<Faction> allFactions = new ArrayList<>();
  private final List<CalistisPlayer> allPlayers = new ArrayList<>();

  public CalistisManager(Calistis calistis) {
    this.calistis = calistis;
  }

  public CalistisPlayer getCalistisPlayer(UUID uuid) {
    return this.allPlayers
        .parallelStream()
        .filter(calistisPlayer -> calistisPlayer.getUuid().equals(uuid))
        .findAny()
        .orElse(null);
  }

  public CalistisPlayer getCalistisPlayer(Player player) {
    return this.getCalistisPlayer(player.getUniqueId());
  }

  public boolean createCalistisPlayer(UUID uuid) {
    return this.allPlayers.add(new CalistisPlayer());
  }

  public Faction getFaction(String name) {
    return this.allFactions
        .parallelStream()
        .filter(fac -> fac.getName().equalsIgnoreCase(name))
        .findAny()
        .orElse(null);
  }

  public Calistis getCalistis() {
    return calistis;
  }

  public List<Faction> getAllFactions() {
    return allFactions;
  }

  public List<CalistisPlayer> getAllPlayers() {
    return allPlayers;
  }

}
