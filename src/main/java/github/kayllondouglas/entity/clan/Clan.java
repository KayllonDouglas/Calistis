package github.kayllondouglas.entity.clan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clan {
  
  private String tag, description;
  private int power;

}
