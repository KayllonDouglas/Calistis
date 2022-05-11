package team.calistis.faction;

import java.util.UUID;

public class FactionIntegrant {

  private final UUID integrantId;
  private final FactionRole integrantRole;

  public FactionIntegrant(UUID integrantId, FactionRole integrantRole) {
    this.integrantId = integrantId;
    this.integrantRole = integrantRole;
  }

  public UUID getIntegrantId() {
    return integrantId;
  }

  public FactionRole getIntegrantRole() {
    return integrantRole;
  }

}
