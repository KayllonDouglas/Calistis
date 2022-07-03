package team.calistis.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import team.calistis.faction.Faction;
import team.calistis.faction.FactionRole;

@AllArgsConstructor
@Data
public class CorePlayer {

  private Faction faction;
  private FactionRole factionRole;

  private double money,
      cash,
      mobCoins,
      shards;

}
