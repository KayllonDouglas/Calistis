package team.calistis;

import team.calistis.zcore.CoreBase;

public class Core extends CoreBase {

  private static Core instance;

  @Override
  public void onCoreEnable() {
    instance = this;
    this.getLogger().info("§7CalistisCore has been enabled, version: §7[§a" + this.getDescription().getVersion() + "§7].");
  }

  @Override
  public void onCoreDisable() {
    this.getLogger().info("§7CalistisCore has been disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

}
