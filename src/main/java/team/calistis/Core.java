package team.calistis;

import cn.nukkit.plugin.PluginBase;

public class Core extends PluginBase {

  private static Core instance;

  @Override
  public void onEnable() {
    instance = this;
    this.getLogger().info("§aCalistisCore is now enabled, version " + this.getDescription().getVersion() + ".");
  }

  @Override
  public void onDisable() {
    this.getLogger().info("§cCalistisCore is now disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

}
