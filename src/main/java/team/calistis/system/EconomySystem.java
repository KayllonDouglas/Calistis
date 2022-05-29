package team.calistis.system;

import cn.nukkit.Player;
import lombok.Getter;
import team.calistis.economy.EconomyAccount;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class EconomySystem {

  @Getter
  private static final Set<EconomyAccount> economyAccounts = new HashSet<>();

  private EconomySystem() {
    throw new IllegalStateException("This class cannot be stantiated.");
  }

  public static boolean hasEconomyAccount(Player player) {
    return getEconomyAccount(player).isPresent();
  }

  public static Optional<EconomyAccount> getEconomyAccount(Player player) {
    return getEconomyAccounts()
            .stream()
            .filter(account -> account.getUniqueId().equals(player.getUniqueId()))
            .findFirst();
  }

  public static void createEconomyAccount(EconomyAccount economyAccount) {
    economyAccounts.add(economyAccount);
  }

  public boolean hasEnoughMoney(Player player, double value) {
    return getEconomyAccount(player)
            .map(account -> account.getMoney() >= value)
            .orElse(false);
  }

  public boolean hasEnoughCash(Player player, double value) {
    return getEconomyAccount(player)
            .map(account -> account.getCash() >= value)
            .orElse(false);
  }

  public static double getMoney(Player player) {
    return getEconomyAccount(player)
            .map(EconomyAccount::getMoney)
            .orElse(0.0);
  }

  public static double getCash(Player player) {
    return getEconomyAccount(player)
            .map(EconomyAccount::getCash)
            .orElse(0.0);
  }

  public static void setMoney(Player player, double value) {
    getEconomyAccount(player)
            .ifPresent(account -> account.setMoney(value));
  }

  public static void setCash(Player player, double value) {
    getEconomyAccount(player)
            .ifPresent(account -> account.setCash(value));
  }

  public static void increaseMoney(Player player, double value) {
    getEconomyAccount(player)
            .ifPresent(account -> account.setMoney(account.getMoney() + value));
  }

  public static void increaseCash(Player player, double value) {
    getEconomyAccount(player)
            .ifPresent(account -> account.setCash(account.getCash() + value));
  }

  public static void reduceMoney(Player player, double value) {
    getEconomyAccount(player)
            .ifPresent(account -> account.setMoney(account.getMoney() - value));
  }

  public static void reduceCash(Player player, double value) {
    getEconomyAccount(player)
            .ifPresent(account -> account.setCash(account.getCash() - value));
  }

  public static void payMoney(Player payer, Player target, double value) {
    getEconomyAccount(payer).ifPresent(payerAccount -> getEconomyAccount(target).ifPresent(targetAccount -> {
      payerAccount.setMoney(payerAccount.getMoney() - value);
      targetAccount.setMoney(targetAccount.getMoney() + value);
    }));
  }

}
