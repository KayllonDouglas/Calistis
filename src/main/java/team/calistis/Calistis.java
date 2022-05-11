package team.calistis;

import team.calistis.zcore.CalistisPlugin;

public class Calistis extends CalistisPlugin {

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
  }

  @Override
  public void onConfigurationLoad() {
  }

  @Override
  public void onConfigurationSave() {

  }

}
