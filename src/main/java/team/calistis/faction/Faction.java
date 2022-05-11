package team.calistis.faction;

import java.util.List;

public class Faction {

  private final String name, tag;
  private final FactionIntegrant leader;
  private final List<FactionIntegrant> members;
  private final List<FactionIntegrant> officers;

  private final double balance;
  private final int power;

  public Faction(String name, String tag, FactionIntegrant leader, List<FactionIntegrant> members,
      List<FactionIntegrant> officers, double balance, int power) {
    this.name = name;
    this.tag = tag;
    this.leader = leader;
    this.members = members;
    this.officers = officers;
    this.balance = balance;
    this.power = power;
  }

  public String getName() {
    return name;
  }

  public String getTag() {
    return tag;
  }

  public FactionIntegrant getLeader() {
    return leader;
  }

  public List<FactionIntegrant> getMembers() {
    return members;
  }

  public List<FactionIntegrant> getOfficers() {
    return officers;
  }

  public double getBalance() {
    return balance;
  }

  public int getPower() {
    return power;
  }

}
