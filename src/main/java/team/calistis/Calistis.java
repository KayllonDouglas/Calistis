package team.calistis;

import team.calistis.zcore.CalistisPlugin;

public class Calistis extends CalistisPlugin {

  private static Calistis instance;

  @Override
  public boolean onCoreEnable() {
    if (!this.registerListeners() && !this.registerManagers()) {
      this.suicide();
      return false;
    }
    this.getLogger().info("§aCalistisCore is now enabled, version: " + this.getDescription().getVersion() + ".");
    return false;
  }

  @Override
  public boolean onCoreDisable() {
    this.getLogger().info("§cCalistisCore is now disabled.");
    return false;
  }

  public boolean registerManagers() {
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
