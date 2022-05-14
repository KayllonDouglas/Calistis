package team.calistis.zcore;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.LogLevel;

public abstract class CalistisPlugin extends PluginBase {

  @Override
  public void onLoad() {
    this.onPluginLoad();
  }

  @Override
  public void onEnable() {
    this.getLogger().log(LogLevel.NOTICE, "Calistis is now enabling...");
    this.getDataFolder().mkdir();
    this.onPluginEnable();
    this.onListenerRegistry();
    this.onManagerRegistry();
    this.onConfigurationLoad();
  }

  @Override
  public void onDisable() {
    this.getLogger().log(LogLevel.NOTICE, "Calistis is now disabling...");
    this.onConfigurationSave();
    this.onPluginDisable();
  }

  public abstract void onPluginLoad();

  public abstract void onPluginEnable();
  public abstract void onPluginDisable();
  public abstract void onManagerRegistry();
  public abstract void onListenerRegistry();
  protected abstract void onConfigurationLoad();
  protected abstract void onConfigurationSave();

}
