package team.calistis.system.general;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.nukkit.Player;
import team.calistis.components.economy.PlayerBank;

public class EconomySystem {

  private static final Map<UUID, PlayerBank> playerBanks = new HashMap<>();

  public static boolean hasBank(Player player) {
    return playerBanks.containsKey(player.getUniqueId());
  }

  public static PlayerBank getBank(Player player) {
    return playerBanks.get(player.getUniqueId());
  }

  public static PlayerBank createBank(Player player, PlayerBank playerBank) {
    return playerBanks.put(player.getUniqueId(), playerBank);
  }

  public static PlayerBank deleteBank(Player player) {
    return playerBanks.remove(player.getUniqueId());
  }

  public static boolean hasEnoughMoney(Player player, double amount) {
    return getBank(player).getMoney() >= amount;
  }

  public static double getMoney(Player player) {
    return getBank(player).getMoney();
  }

  public static void increaseMoney(Player player, double amount) {
    getBank(player).setMoney(getMoney(player) + amount);
  }

  public static void decreaseMoney(Player player, double amount) {
    getBank(player).setMoney(getMoney(player) - amount);
  }

  public static void setMoney(Player player, double amount) {
    getBank(player).setMoney(amount);
  }

  public static Map<UUID, PlayerBank> getPlayerbanks() {
    return playerBanks;
  }

}
