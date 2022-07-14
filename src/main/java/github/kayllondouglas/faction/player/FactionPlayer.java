package github.kayllondouglas.faction.player;

import github.kayllondouglas.faction.Faction;
import github.kayllondouglas.faction.FactionRole;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FactionPlayer {

  private Faction faction;
  private FactionRole factionRole;

  private double money, cash, shards;

}
