package team.calistis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import team.calistis.player.CorePlayer;
import team.calistis.zcore.CoreBase;

public class Core extends CoreBase {

  private Map<UUID, CorePlayer> corePlayers = new HashMap<>();

  @Override
  public void onCoreEnable() {
    this.getLogger().info("§7CalistisCore has been enabled, version: §7[§a" + this.getDescription().getVersion() + "§7].");
  }

  @Override
  public void onCoreDisable() {
    this.getLogger().info("§7CalistisCore has been disabled.");
  }

  public Map<UUID, CorePlayer> getCorePlayers() {
    return corePlayers;
  }

}
