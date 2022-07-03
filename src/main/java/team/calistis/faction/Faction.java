package team.calistis.faction;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Faction {

  private String tag,
      description;

  private int power;

}
