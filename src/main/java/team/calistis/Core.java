package team.calistis;

import lombok.extern.log4j.Log4j2;
import team.calistis.zcore.Engine;

@Log4j2
public class Core extends Engine {

  public static Core instance;

  @Override
  public void onCoreLoad() {
    log.info("§7Plugin environment loaded.");
  }

  @Override
  public void onCoreEnable() {
    instance = this;
    this.getServer().getPluginManager().registerEvents(new CoreListener(), this);
    log.info("§7Plugin environment enabled, version [" + this.getDescription().getVersion() + "].");
  }

  @Override
  public void onCoreDisable() {
    log.info("§7Plugin environment disabled.");
  }

  public static Core getInstance() {
      return instance;
  }

}
