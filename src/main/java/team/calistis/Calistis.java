package team.calistis;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.LogLevel;
import team.calistis.authentication.AuthenticationManager;

public class Calistis extends PluginBase {

  private static Calistis instance;

  @Override
  public void onEnable() {
    instance = this;
    this.getDataFolder().mkdir();

    AuthenticationManager.initListener();
    AuthenticationManager.initConfiguration();

    this.getLogger().log(LogLevel.INFO, "§aCalistis is now enabled.");
  }

  @Override
  public void onDisable() {

    this.getLogger().log(LogLevel.INFO, "§cCalistis is now disabled.");
  }

  public static Calistis getInstance() {
    return instance;
  }

}
