package team.calistis;

import lombok.Data;
import team.calistis.components.Faction;

import java.util.UUID;

@Data
public class CalistisPlayer {

  private UUID uuid;
  private double balance;
  private Faction faction;

}
