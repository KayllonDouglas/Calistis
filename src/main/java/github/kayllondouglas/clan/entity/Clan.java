package github.kayllondouglas.clan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clan {
  
  private String tag, description;
  private int power;

}
