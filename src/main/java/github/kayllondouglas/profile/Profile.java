package github.kayllondouglas.profile;

import github.kayllondouglas.faction.Faction;
import github.kayllondouglas.faction.FactionRole;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Profile {
  
  private Faction faction;
  private FactionRole factionRole;

}
