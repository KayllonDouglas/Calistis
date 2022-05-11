package team.calistis.faction;

import java.util.List;

public class Faction {

  public static final int MAX_FACTION_NAME_LENGTH = 10;
  public static final int MAX_FACTION_TAG_LENGTH = 3;
  public static final int MAX_FACTION_MEMBERS_LENGTH = 30;
  public static final int MAX_FACTION_OFFICERS_LENGTH = 3;
  public static final int MAX_FACTION_MONEY_LENGTH = 999999999;
  public static final int MAX_FACTION_POWER_LENGTH = 100;

  private final String name;
  private final String tag;
  private final FactionMember leader;
  private final List<FactionMember> members;
  private final List<FactionMember> officers;

  private final double money;
  private final int power;

  public Faction(String name, String tag, FactionMember leader,
                 List<FactionMember> members, List<FactionMember> officers,
                 double money, int power) {
    this.name = name;
    this.tag = tag;
    this.leader = leader;
    this.members = members;
    this.officers = officers;
    this.money = money;
    this.power = power;
  }

  public String getName() {
    return name;
  }

  public String getTag() {
    return tag;
  }

  public FactionMember getLeader() {
    return leader;
  }

  public List<FactionMember> getMembers() {
    return members;
  }

  public List<FactionMember> getOfficers() {
    return officers;
  }

  public double getMoney() {
    return money;
  }

  public int getPower() {
    return power;
  }

}
