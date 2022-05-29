package team.calistis.system;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import cn.nukkit.Player;
import lombok.Getter;
import team.calistis.economy.EconomyAccount;

public class EconomySystem {

  @Getter
  private static Set<EconomyAccount> economyAccounts = new HashSet<>();

  private EconomySystem() {
    throw new IllegalStateException("This class cannot be stantiated.");
  }

  public static boolean hasEconomyAccount(Player player) {
    return getEconomyAccount(player) != null;
  }

  public static EconomyAccount getEconomyAccount(Player player) {
    return economyAccounts.parallelStream()
        .filter(ea -> ea.getUniqueId().equals(player.getUniqueId()))
        .findFirst().get();
  }

  public static boolean createEconomyAccount(EconomyAccount economyAccount) {
    return economyAccounts.add(economyAccount);
  }

  public boolean hasEnoughMoney(Player player, double value) {
    return getEconomyAccount(player)
        .getMoney() >= value;
  }

  public boolean hasEnoughCash(Player player, double value) {
    return getEconomyAccount(player)
        .getCash() >= value;
  }

  public static double getMoney(Player player) {
    return getEconomyAccount(player)
        .getMoney();
  }

  public static double getCash(Player player) {
    return getEconomyAccount(player)
        .getCash();
  }

  public static void setMoney(Player player, double value) {
    getEconomyAccount(player)
        .setMoney(value);
  }

  public static void setCash(Player player, double value) {
    getEconomyAccount(player)
        .setCash(value);
  }

  public static void increaseMoney(Player player, double value) {
    setMoney(player, getMoney(player) + value);
  }

  public static void increaseCash(Player player, double value) {
    setCash(player, getCash(player) + value);
  }

  public static void reduceMoney(Player player, double value) {
    setMoney(player, getMoney(player) - value);
  }

  public static void reduceCash(Player player, double value) {
    setCash(player, getCash(player) - value);
  }

  public static void payMoney(Player payer, Player target, double value) {
    reduceMoney(payer, value);
    increaseMoney(target, value);
  }

}
