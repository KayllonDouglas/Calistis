package team.calistis.faction;

import java.util.HashSet;
import java.util.Set;

import team.calistis.Calistis;

public class FactionManager {

  private final Calistis calistis;
  private final Set<Faction> allFactions = new HashSet<>();

  public FactionManager(Calistis calistis) {
    this.calistis = calistis;
  }

  public Faction getFaction(String name) {
    return this.allFactions
        .stream()
        .filter(faction -> faction.getName().equals(name))
        .findAny().orElse(null);
  }

  public String getTag(String name) {
    return this.getFaction(name).getTag();
  }

  public FactionIntegrant getLeader(String name) {
    return this.getFaction(name).getLeader();
  }
 
  public double getBalance(String name) {
    return this.getFaction(name).getBalance();
  }

  public int getPower(String name) {
    return this.getFaction(name).getPower();
  }

  public Set<Faction> getAllFactions() {
    return allFactions;
  }

  public Calistis getCalistis() {
    return calistis;
  }

}
