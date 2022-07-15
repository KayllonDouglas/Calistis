package github.kayllondouglas.faction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Faction {
  
  private String name;
  private String tag;
  private String description;

  private int power;

}
