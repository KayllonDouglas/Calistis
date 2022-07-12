package github.kayllondouglas;

import cn.nukkit.plugin.PluginBase;

public class Core extends PluginBase {

  @Override
  public void onEnable() {

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

}
