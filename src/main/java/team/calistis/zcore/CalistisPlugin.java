package team.calistis.zcore;

import cn.nukkit.plugin.PluginBase;

public abstract class CalistisPlugin extends PluginBase {

  private static CalistisPlugin instance;

  @Override
  public void onLoad() {
    this.onPluginLoad();
  }

  @Override
  public void onEnable() {
    instance = this;
    this.onPluginEnable();
    this.onManagerRegistry();
    this.onConfigurationLoad();
  }

  @Override
  public void onDisable() {
    this.onPluginDisable();
    this.onConfigurationSave();
  }

  public abstract void onPluginEnable();
  public abstract void onPluginDisable();
  public abstract void onPluginLoad();

  public abstract void onConfigurationLoad();
  public abstract void onConfigurationSave();

  public abstract void onManagerRegistry();

  public static CalistisPlugin getInstance() {
    return instance;
  }

}
