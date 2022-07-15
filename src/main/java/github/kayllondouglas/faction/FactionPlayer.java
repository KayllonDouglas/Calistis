package github.kayllondouglas.faction;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FactionPlayer {
  
  private UUID uniqueId;
  
  private double money;
  private double cash;
  private double shard;

  private Faction faction;

}
