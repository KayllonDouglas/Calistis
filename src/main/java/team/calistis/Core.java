package team.calistis;

import cn.nukkit.plugin.PluginBase;
import team.calistis.command.CommandManager;

public class Core extends PluginBase {

  private static Core instance;

  @Override
  public void onEnable() {
    instance = this;
    new CommandManager(this);
    this.getServer().getPluginManager().registerEvents(new CoreListener(this), this);
    this.getLogger().info("§aCalistisCore is now enabled, version " + this.getDescription().getVersion() + ".");
  }

  @Override
  public void onDisable() {
    this.getLogger().info("§cCalistisCore is now disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

}
