package github.kayllondouglas;

import cn.nukkit.plugin.PluginBase;

public class Core extends PluginBase {

  private static Core instance;

  @Override
  public void onEnable() {
    instance = this;
    this.getLogger().info("§aCalistis is now enabled");
  }

  @Override
  public void onDisable() {
    this.getLogger().info("§cCalistis is now disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

}
