package team.calistis.faction;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FactionRole {

  RECRUIT("+"),
  MEMBER("*"),
  OFFICER("**"),
  LEADER("***");

  private String suffix;

  public String getSuffix() {
      return suffix;
  }

}
