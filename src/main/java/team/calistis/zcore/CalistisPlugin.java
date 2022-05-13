package team.calistis.zcore;

import cn.nukkit.plugin.PluginBase;

public abstract class CalistisPlugin extends PluginBase {

  @Override
  public void onLoad() {
    this.onPluginLoad();
  }

  @Override
  public void onEnable() {
    this.getDataFolder().mkdir();
    this.onPluginEnable();
    this.onCommandRegistry();
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

  public abstract void onCommandRegistry();
}
