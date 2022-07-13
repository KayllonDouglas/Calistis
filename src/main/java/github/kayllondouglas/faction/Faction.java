package github.kayllondouglas.faction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Faction {

  private String tag, description;
  private int power;

}
