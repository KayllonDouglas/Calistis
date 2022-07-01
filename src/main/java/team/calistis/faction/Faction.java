package team.calistis.faction;

import java.util.Map;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Faction {
  
  private String tag, description;
  private Map<UUID, FactionMember> members;
  private int power;

}
