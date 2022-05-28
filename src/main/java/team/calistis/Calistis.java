package team.calistis;

import lombok.Getter;
import team.calistis.command.CommandController;
import team.calistis.zcore.CalistisPlugin;

@Getter
public class Calistis extends CalistisPlugin {

  private static Calistis instance;
  private CommandController commandController;

  @Override
  public boolean onCoreEnable() {
    this.commandController = new CommandController(this);
    this.getServer().getPluginManager().registerEvents(new CalistisListener(this), this);
    this.getLogger().info("§aCalistisCore is now enabled, version: " + this.getDescription().getVersion() + ".");
    return false;
  }

  @Override
  public boolean onCoreDisable() {
    this.getLogger().info("§cCalistisCore is now disabled.");
    return false;
  }

  public static Calistis getInstance() {
    if (instance == null) instance = new Calistis();
    return instance;
  }

}
