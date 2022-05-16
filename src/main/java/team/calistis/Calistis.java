package team.calistis;

import java.io.File;

import cn.nukkit.command.PluginCommand;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.LogLevel;
import team.calistis.api.CalistisPlayerApi;
import team.calistis.command.AccountCommandManager;
import team.calistis.zcore.CalistisPlugin;

public class Calistis extends CalistisPlugin {

  private static Calistis instance;
  private static Config calistisPlayerConfiguration;

  @Override
  public void onPluginLoad() {
  }

  @Override
  public void onPluginEnable() {
    instance = this;
    ((PluginCommand<?>) this.getCommand("conta")).setExecutor(new AccountCommandManager());
    calistisPlayerConfiguration = new Config(new File(this.getDataFolder(), "PlayersRepository.json"), Config.JSON);
    this.getLogger().log(LogLevel.INFO, "§aCalistis is now enabled.");
  }

  @Override
  public void onPluginDisable() {
    this.getLogger().log(LogLevel.INFO, "§cCalistis is now disabled.");
  }

  @Override
  public void onManagerRegistry() {
  }

  @Override
  public void onListenerRegistry() {
    this.getServer().getPluginManager().registerEvents(new CalistisListener(), this);
  }

  @Override
  public void onConfigurationLoad() {
    CalistisPlayerApi.load();
  }

  @Override
  public void onConfigurationSave() {
    CalistisPlayerApi.save();
  }

  public static Calistis getInstance() {
    return instance;
  }

  public static Config getCalistisPlayerConfiguration() {
    return calistisPlayerConfiguration;
  }

}
