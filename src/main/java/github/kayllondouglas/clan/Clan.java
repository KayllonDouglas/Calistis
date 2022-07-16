package github.kayllondouglas.clan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clan {
  
  private String name, tag, description;
  private int power;

}
