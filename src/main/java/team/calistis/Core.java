package team.calistis;

import cn.nukkit.plugin.PluginBase;

public class Core extends PluginBase {

  @Override
  public void onEnable() {
    this.getLogger().info("§aEnabled successfully");
  }

  @Override
  public void onDisable() {
    this.getLogger().info("§cDisabled successfully");
  }

}
