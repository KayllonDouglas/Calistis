package team.calistis.zcore;

import cn.nukkit.plugin.PluginBase;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class Engine extends PluginBase {

  @Override
  public void onLoad() {
    log.info("§7Loading plugin environment, please wait...");
    this.onCoreLoad();
  }

  @Override
  public void onEnable() {
    log.info("§7Enabling plugin environment, please wait...");
    this.onCoreEnable();
  }

  @Override
  public void onDisable() {
    log.info("§7Disabling plugin environment, plase wait...");
    this.onCoreDisable();
  }

  public abstract void onCoreLoad();
  public abstract void onCoreEnable();
  public abstract void onCoreDisable();

}
