package team.calistis;

import cn.nukkit.utils.Config;
import team.calistis.manager.PlayerManager;

import java.io.File;

public class CalistisManager {

  private final Calistis calistis;

  private Config playerConfiguration;

  private PlayerManager playerManager;

  public CalistisManager(Calistis calistis) {
    this.calistis = calistis;
    this.configurationInit();
    this.initManagers();
  }

  private void configurationInit() {
    this.playerConfiguration = new Config(new File(this.calistis.getDataFolder(), "PlayersConfiguration.json"), Config.JSON);
  }

  private void initManagers() {
    this.playerManager = new PlayerManager(this);
  }

  public Calistis getCalistis() {
    return calistis;
  }

  public PlayerManager getPlayerManager() {
    return playerManager;
  }

  public Config getPlayerConfiguration() {
    return playerConfiguration;
  }

}
