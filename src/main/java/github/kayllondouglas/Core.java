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

  }

  @Override
  public void onDisable() {

  }

  public static Core getInstance() {
    return instance;
  }

}
