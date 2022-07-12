package github.kayllondouglas;

import cn.nukkit.plugin.PluginBase;

public class Core extends PluginBase {

  private static Core instance;

  @Override
  public void onEnable() {
    instance = this;

    this.getServer()
        .getPluginManager()
        .registerEvents(new CoreListener(), this);

    this.getLogger()
        .info("§7Calistis is now enabled");
  }

  @Override
  public void onDisable() {

    this.getLogger()
        .info("§7Calistis is now disabled");
  }

  public static Core getInstance() {
    return instance;
  }

}
