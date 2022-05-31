package team.calistis;

import com.nukkitx.fakeinventories.inventory.FakeInventories;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.service.RegisteredServiceProvider;
import team.calistis.commands.CommandManager;
import team.calistis.economy.BankManager;

public class Calistis extends PluginBase {

  private static Calistis instance;
  private BankManager bankManager;
  private CommandManager commandManager;

  @Override
  public void onEnable() {
    instance = this;

    this.bankManager = new BankManager(this);
    this.commandManager = new CommandManager(this);
    this.getServer().getPluginManager().registerEvents(new CalistisListener(this), this);
    this.getLogger().info("§aCalistisCore is now enabled, version " + this.getDescription().getVersion() + ".");
  }

  @Override
  public void onDisable() {
    this.getLogger().info("§cCalistisCore is now disabled.");
  }

  public static Calistis getInstance() {
    return instance;
  }

  public BankManager getBankManager() {
    return bankManager;
  }

  public CommandManager getCommandManager() {
    return commandManager;
  }

}
