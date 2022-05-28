package team.calistis.api.economy;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EconomyAPI {

  @Getter
  private static final Map<UUID, EconomyAccount> economyAccounts = new HashMap<>();

  private EconomyAPI() {
    throw new IllegalStateException("This class is not meant to be instantiated");
  }

  public static boolean hasAccount(UUID uuid) {
    return economyAccounts.containsKey(uuid);
  }

  public static EconomyAccount getAccount(UUID uuid) {
    return economyAccounts.get(uuid);
  }

  public static EconomyAccount createAccount(UUID uuid, EconomyAccount economyAccount) {
    return economyAccounts.put(uuid, economyAccount);
  }

  public static EconomyAccount removeAccount(UUID uuid) {
    return economyAccounts.remove(uuid);
  }

  public static double getMoney(UUID uuid) {
    return getAccount(uuid).getCurrentMoney();
  }

  public static void setMoney(UUID uuid, double amount) {
    getAccount(uuid).setCurrentMoney(amount);
  }

  public static void reduceMoney(UUID uuid, double amount) {
    getAccount(uuid).setCurrentMoney(economyAccounts.get(uuid).getCurrentMoney() - amount);
  }

  public static void increaseMoney(UUID uuid, double amount) {
    getAccount(uuid).setCurrentMoney(economyAccounts.get(uuid).getCurrentMoney() + amount);
  }

  public static boolean hasEnoughMoney(UUID uuid, double amount) {
    return getAccount(uuid).getCurrentMoney() >= amount;
  }

  public static double getCash(UUID uuid) {
    return getAccount(uuid).getCurrentCash();
  }

  public static void setCash(UUID uuid, double amount) {
    getAccount(uuid).setCurrentCash(amount);
  }

  public static void reduceCash(UUID uuid, double amount) {
    getAccount(uuid).setCurrentCash(economyAccounts.get(uuid).getCurrentCash() - amount);
  }

  public static void increaseCash(UUID uuid, double amount) {
    getAccount(uuid).setCurrentCash(economyAccounts.get(uuid).getCurrentCash() + amount);
  }

  public static boolean hasEnoughCash(UUID uuid, double amount) {
    return getAccount(uuid).getCurrentCash() >= amount;
  }

}
