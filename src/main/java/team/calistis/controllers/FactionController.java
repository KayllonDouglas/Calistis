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

  public static Faction getFaction(String factionName) {
    return factionsMap.get(factionName);
  }

  public static Faction deleteFaction(String factionName) {
    return factionsMap.remove(factionName);
  }

  public static String getTag(String factionName) {
    return getFaction(factionName)
            .getTag();
  }

  public static int getPower(String factionName) {
    return getFaction(factionName)
            .getPower();
  }

  public static String getDescription(String name) {
    return getFaction(name)
            .getDescription();
  }

  public static FactionMember getMember(String name, UUID uuid) {
    return getFaction(name)
            .getMembers()
            .get(uuid);
  }

  public static FactionRole getMemberRole(String name, UUID uuid) {
    return getMember(name, uuid)
            .getMemberRole();
  }

}
