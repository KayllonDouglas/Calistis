package team.calistis;

import team.calistis.faction.FactionManager;
import team.calistis.zcore.CalistisPlugin;

public class Calistis extends CalistisPlugin {

  private FactionManager factionManager;

  @Override
  public void onPluginLoad() {
    this.getLogger().info("§aCalistisCore loaded successfully.");
  }

  @Override
  public void onPluginEnable() {
    this.getLogger().info("§aCalistisCore enabled successfully.");
  }

  @Override
  public void onPluginDisable() {
    this.getLogger().info("§aCalistisCore disabled successfully.");
  }

  @Override
  public void onManagerRegistry() {
    this.factionManager = new FactionManager(this);
  }

  @Override
  public void onConfigurationLoad() {
    this.factionManager.load();
  }

  @Override
  public void onConfigurationSave() {
    this.factionManager.save();
  }

  public FactionManager getFactionManager() {
    return factionManager;
  }

}
