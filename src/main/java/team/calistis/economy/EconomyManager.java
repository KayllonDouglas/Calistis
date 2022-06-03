package team.calistis.economy;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.nukkit.Player;

public class EconomyManager {

  private static final Map<UUID, PlayerEconomy> economyAccounts = new HashMap<>();

  public static boolean hasEconomy(Player player) {
    return economyAccounts.containsKey(player.getUniqueId());
  }

  public static PlayerEconomy getEconomy(Player player) {
    return economyAccounts.get(player.getUniqueId());
  }

  public static PlayerEconomy createEconomy(Player player, PlayerEconomy playerEconomy) {
    return economyAccounts.put(player.getUniqueId(), playerEconomy);
  }

  public static PlayerEconomy removeEconomy(Player player) {
    return economyAccounts.remove(player.getUniqueId());
  }

  public static boolean hasEnoughMoney(Player player, double amount) {
    return getEconomy(player).getMoney() >= amount;
  }

  public static boolean hasEnoughCash(Player player, double amount) {
    return getEconomy(player).getCash() >= amount;
  }

  public static double getMoney(Player player) {
    return getEconomy(player).getMoney();
  }

  public static double getCash(Player player) {
    return getEconomy(player).getCash();
  }

  public static void setMoney(Player player, double amount) {
    getEconomy(player).setMoney(amount);
  }

  public static void setCash(Player player, double amount) {
    getEconomy(player).setCash(amount);
  }

  public static void increaseMoney(Player player, double amount) {
    setMoney(player, getMoney(player) + amount);
  }

  public static void increaseCash(Player player, double amount) {
    setCash(player, getCash(player) + amount);
  }

  public static void decreaseMoney(Player player, double amount) {
    setMoney(player, getMoney(player) - amount);
  }

  public static void decreaseCash(Player player, double amount) {
    setCash(player, getCash(player) - amount);
  }

  public static Map<UUID, PlayerEconomy> getEconomyaccounts() {
    return economyAccounts;
  }
}
