package team.calistis;

import cn.nukkit.command.PluginCommand;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.LogLevel;
import team.calistis.command.AccountCommandManager;
import team.calistis.system.BroadcasterSystem;

public class Calistis extends PluginBase {

  private static Calistis instance;

  @Override
  public void onEnable() {
    instance = this;

    this.getServer().getPluginManager().registerEvents(new CalistisListener(), this);

    if (!this.initCommandManager()) return;
    if (!this.loadConfigurations()) return;

    BroadcasterSystem.init();
    BroadcasterSystem.autoAnnounce();

    this.getLogger().log(LogLevel.INFO, "§aCalistis is now enabled.");
  }

  @Override
  public void onDisable() {
    if (!this.saveConfigurations()) return;

    this.getLogger().log(LogLevel.INFO, "§cCalistis is now disabled.");
  }

  public boolean initCommandManager() {
    ((PluginCommand<?>) this.getCommand("conta")).setExecutor(new AccountCommandManager());
    return true;
  }

  public boolean loadConfigurations() {
    return true;
  }

  public boolean saveConfigurations() {
    return true;
  }

  public static Calistis getInstance() {
    return instance;
  }

}
