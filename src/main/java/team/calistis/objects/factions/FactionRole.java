package team.calistis.objects.factions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FactionRole {

  RECRUIT("+"),
  MEMBER("*"),
  OFFICER("**"),
  LEADER("***");

  private final String suffix;

}
