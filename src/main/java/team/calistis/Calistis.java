package team.calistis;

import cn.nukkit.command.PluginCommand;
import team.calistis.command.EconomyCommandController;
import team.calistis.zcore.CalistisPlugin;

public class Calistis extends CalistisPlugin {

  private static Calistis instance;

  @Override
  public boolean onCoreEnable() {
    if (!this.registerListeners() && !this.registerManagers() && !this.registerControllers()) {
      this.suicide();
      return false;
    }
    this.getLogger().info("§aCalistisCore is now enabled, version: " + this.getDescription().getVersion() + ".");
    return true;
  }

  @Override
  public boolean onCoreDisable() {
    this.getLogger().info("§cCalistisCore is now disabled.");
    return true;
  }

  public boolean registerManagers() {
    return true;
  }

  public boolean registerControllers() {
    ((PluginCommand<?>) this.getCommand("money")).setExecutor(new EconomyCommandController());
    return true;
  }

  public boolean registerListeners() {
    this.getServer().getPluginManager().registerEvents(new  CalistisListener(this), this);
    return true;
  }

  public static Calistis getInstance() {
    if (instance == null) instance = new Calistis();
    return instance;
  }

}
