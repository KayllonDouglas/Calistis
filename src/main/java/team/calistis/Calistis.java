package team.calistis;

import cn.nukkit.command.PluginCommand;
import team.calistis.manager.command.FactionCommandManager;
import team.calistis.zcore.CalistisPlugin;

public class Calistis extends CalistisPlugin {

  private static Calistis instance;
  private CalistisManager calistisManager;

  @Override
  public void onPluginLoad() {
    this.getLogger().info("§aCalistisCore loaded successfully.");
  }

  @Override
  public void onPluginEnable() {
    instance = this;
    this.getLogger().info("§aCalistisCore enabled successfully.");
  }

  @Override
  public void onPluginDisable() {
    this.getLogger().info("§aCalistisCore disabled successfully.");
  }

  @Override
  public void onManagerRegistry() {
    this.calistisManager = new CalistisManager(this);
  }

  @Override
  public void onCommandRegistry() {
    ((PluginCommand<?>) this.getCommand("f")).setExecutor(new FactionCommandManager(this));
  }

  @Override
  public void onConfigurationLoad() {
  }

  @Override
  public void onConfigurationSave() {
  }

  public static Calistis getInstance() {
    return instance;
  }

  public CalistisManager getCalistisManager() {
    return calistisManager;
  }

}
