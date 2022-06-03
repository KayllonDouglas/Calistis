package team.calistis;

import team.calistis.command.CommandManager;
import team.calistis.zcore.CoreBase;

public class Core extends CoreBase {

  private static Core instance;

  @Override
  public void onCoreEnable() {
    instance = this;
    this.getServer().getPluginManager().registerEvents(new CoreListener(), this);
    CommandManager.init();
    this.getLogger().info("§7CalistisCore has been enabled, version: §a" + this.getDescription().getVersion() + "§7.");
  }

  @Override
  public void onCoreDisable() {
    this.getLogger().info("§7CalistisCore has been disabled, version: §c" + this.getDescription().getVersion() + "§7.");
  }

  public static Core getInstance() {
    return instance;
  }

}
