package team.calistis.zcore;

import cn.nukkit.plugin.PluginBase;

public abstract class CoreBase extends PluginBase {

  @Override
  public void onEnable() {
    this.getLogger().notice("Enabling CalistisCore, please wait some time...");
    this.onCoreEnable();
  }

  @Override
  public void onDisable() {
    this.getLogger().notice("Disabling CalistisCore, please wait some time...");
    this.onCoreDisable();
  }

  public abstract void onCoreEnable();
  public abstract void onCoreDisable();

}
