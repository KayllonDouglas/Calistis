package team.calistis;

import lombok.AllArgsConstructor;
import lombok.Data;
import team.calistis.faction.Faction;
import team.calistis.faction.FactionRole;

@Data
@AllArgsConstructor
public class CorePlayer {

  private double money, cash;

  private Faction faction;
  private FactionRole factionRole;

}
