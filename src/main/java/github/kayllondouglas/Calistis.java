package github.kayllondouglas;

import cn.nukkit.plugin.PluginBase;

public class Calistis extends PluginBase {

  public static Calistis instance;

  @Override
  public void onEnable() {
    instance = this;
    this.getLogger().info("§7Plugin environment enabled, version [" + this.getDescription().getVersion() + "].");
  }

  @Override
  public void onDisable() {
    this.getLogger().info("§7Plugin environment disabled.");
  }

  public static Calistis getInstance() {
    return instance;
  }

}
