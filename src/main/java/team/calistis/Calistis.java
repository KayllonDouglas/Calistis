package team.calistis;

import cn.nukkit.utils.LogLevel;
import team.calistis.zcore.CalistisPlugin;

public class Calistis extends CalistisPlugin {

  private CalistisManager calistisManager;

  @Override
  public void onPluginLoad() {

  }

  @Override
  public void onPluginEnable() {
    this.getLogger().log(LogLevel.INFO, "§aCalistis is now enabled.");
  }

  @Override
  public void onPluginDisable() {
    this.getLogger().log(LogLevel.INFO, "§cCalistis is now disabled.");
  }

  @Override
  public void onManagerRegistry() {
    this.calistisManager = new CalistisManager(this);
  }

  @Override
  public void onListenerRegistry() {

  }

  @Override
  protected void onConfigurationLoad() {
    this.calistisManager.getPlayerManager().load();
  }

  @Override
  protected void onConfigurationSave() {
    this.calistisManager.getPlayerManager().save();
  }

  public CalistisManager getCalistisManager() {
    return calistisManager;
  }

}
