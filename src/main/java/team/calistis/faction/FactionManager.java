package team.calistis.faction;

import team.calistis.Calistis;

import java.util.ArrayList;
import java.util.List;

public class FactionManager {

  private final Calistis calistis;

  private final List<Faction> allFactions = new ArrayList<>();

  public FactionManager(Calistis calistis) {
    this.calistis = calistis;
  }

  public Faction getFaction(String name) {
    return this.allFactions
            .stream()
            .filter(f -> f.getName().equals(name))
            .findAny()
            .orElse(null);
  }

  public List<Faction> getAllFactions() {
    return allFactions;
  }

  public Calistis getCalistis() {
    return calistis;
  }

}
