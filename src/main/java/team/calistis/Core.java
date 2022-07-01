package team.calistis;

import cn.nukkit.plugin.PluginBase;
import lombok.extern.log4j.Log4j2;
import team.calistis.api.CoreAPI;

@Log4j2
public class Core extends PluginBase {

  private static Core instance;

  @Override
  public void onEnable() {
    instance = this;
    if (!CoreAPI.startApi()) {
      log.error("An error occurred, disabling the plugin.");
      this.getServer().getPluginManager().disablePlugin(this);
      return;
    }
    log.info("§7CalistisCore has been enabled, version: §7[§a" + this.getDescription().getVersion() + "§7].");
  }

  @Override
  public void onDisable() {
    log.info("§7CalistisCore has been disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

}
