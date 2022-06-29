package team.calistis;

import cn.nukkit.plugin.PluginBase;
import lombok.extern.log4j.Log4j2;
import team.calistis.command.CommandManager;

@Log4j2
public class Core extends PluginBase {

  private static Core instance;
  private CommandManager commandManager;

  @Override
  public void onEnable() {
    instance = this;
    this.getServer().getPluginManager().registerEvents(new CoreListener(), this);
    this.commandManager = new CommandManager(this);
    log.info("§7CalistisCore has been enabled, version: §7[§a" + this.getDescription().getVersion() + "§7].");
  }

  @Override
  public void onDisable() {
    log.info("§7CalistisCore has been disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

  public CommandManager getCommandManager() {
      return commandManager;
  }

}
