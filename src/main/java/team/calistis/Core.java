package team.calistis;

import cn.nukkit.plugin.PluginBase;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Core extends PluginBase {

  public static Core instance;

  @Override
  public void onLoad() {
    log.info("§7Plugin environment loaded.");
  }

  @Override
  public void onEnable() {
    instance = this;

    this.getServer().getPluginManager().registerEvents(new CoreListener(this), this);

    log.info("§7Plugin environment enabled, version [" + this.getDescription().getVersion() + "].");
  }

  @Override
  public void onDisable() {
    log.info("§7Plugin environment disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

}
