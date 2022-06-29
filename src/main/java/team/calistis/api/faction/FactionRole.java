package team.calistis.api.faction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FactionRole {
  
  RECRUIT("+"),
  MEMBER("*"),
  OFFICER("**"),
  LEADER("***");

  private String suffix;

}
