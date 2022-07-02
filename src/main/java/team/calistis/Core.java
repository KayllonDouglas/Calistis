package team.calistis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.plugin.PluginBase;

import lombok.extern.log4j.Log4j2;

import team.calistis.command.types.FactionCommand;
import team.calistis.faction.Faction;

@Log4j2
public class Core extends PluginBase {

  private static Core instance;

  @Override
  public void onEnable() {
    instance = this;

    this.getServer().getPluginManager().registerEvents(new CoreListener(), this);
    this.getServer().getCommandMap().register("f", new FactionCommand());

    log.info("§7CalistisCore has been enabled, version: §7[§a" + this.getDescription().getVersion() + "§7].");
  }

  @Override
  public void onDisable() {
    log.info("§7CalistisCore has been disabled.");
  }

  public static Core getInstance() {
    return instance;
  }

}
