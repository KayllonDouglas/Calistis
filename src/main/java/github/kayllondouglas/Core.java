package github.kayllondouglas;

import cn.nukkit.plugin.PluginBase;

public class Core extends PluginBase {

  public static Core instance;

  @Override
  public void onEnable() {
    instance = this;
    this.getLogger().info("§7Plugin environment enabled, version [" + this.getDescription().getVersion() + "].");
  }

  @Override
  public void onDisable() {
    this.getLogger().info("§7Plugin environment disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

}
