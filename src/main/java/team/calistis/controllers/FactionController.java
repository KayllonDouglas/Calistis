package team.calistis.controllers;

import lombok.Getter;
import team.calistis.objects.factions.Faction;
import team.calistis.objects.factions.FactionMember;
import team.calistis.objects.factions.FactionRole;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FactionController {

  @Getter
  private static final Map<String, Faction> factionsMap = new HashMap<>();

  public Faction getFaction(String factionName) {
    return factionsMap.get(factionName);
  }

  public Faction deleteFaction(String factionName) {
    return factionsMap.remove(factionName);
  }

  public String getTag(String factionName) {
    return getFaction(factionName)
            .getTag();
  }

  public int getPower(String factionName) {
    return getFaction(factionName)
            .getPower();
  }

  public String getDescription(String name) {
    return getFaction(name)
            .getDescription();
  }

  public FactionMember getMember(String name, UUID uuid) {
    return getFaction(name)
            .getMembers()
            .get(uuid);
  }

  public FactionRole getMemberRole(String name, UUID uuid) {
    return getMember(name, uuid)
            .getMemberRole();
  }

}
