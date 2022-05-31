package team.calistis.economy;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.nukkit.Player;
import team.calistis.Calistis;

public class BankManager {

  private final Calistis core;
  private final Map<UUID, BankAccount> bankAccounts;

  public BankManager(Calistis core) {
    this.core = core;
    this.bankAccounts = new HashMap<>();
  }

  public boolean hasBank(Player player) {
    return this.bankAccounts.containsKey(player.getUniqueId());
  }

  public BankAccount getBank(Player player) {
    return this.bankAccounts.get(player.getUniqueId());
  }

  public BankAccount createBank(Player player, BankAccount bankAccount) {
    return this.bankAccounts.put(player.getUniqueId(), bankAccount);
  }

  public BankAccount deleteBank(Player player) {
    return this.bankAccounts.remove(player.getUniqueId());
  }

  public boolean hasEnoughMoney(Player player, double value) {
    return this.getBank(player)
        .getMoney() >= value;
  }

  public boolean hasEnoughCash(Player player, double value) {
    return this.getBank(player)
        .getCash() >= value;
  }

  public boolean hasEnoughMobCoins(Player player, double value) {
    return this.getBank(player)
        .getMobCoins() >= value;
  }

  public boolean hasEnoughShards(Player player, double value) {
    return this.getBank(player)
        .getShards() >= value;
  }

  public double getMoney(Player player) {
    return this.getBank(player)
        .getMoney();
  }

  public double getCash(Player player) {
    return this.getBank(player)
        .getCash();
  }

  public double getMobCoins(Player player) {
    return this.getBank(player)
        .getMobCoins();
  }

  public double getShards(Player player) {
    return this.getBank(player)
        .getShards();
  }

  public void increaseMoney(Player player, double value) {
    this.getBank(player)
      .setMoney(this.getMoney(player) + value);
  }

  public void increaseCash(Player player, double value) {
    this.getBank(player)
      .setCash(this.getCash(player) + value);
  }

  public void increaseMobCoins(Player player, double value) {
    this.getBank(player)
      .setMobCoins(this.getMobCoins(player) + value);
  }

  public void increaseShards(Player player, double value) {
    this.getBank(player)
      .setShards(this.getShards(player) + value);
  }

  public void reduceMoney(Player player, double value) {
    this.getBank(player)
        .setMoney(this.getMoney(player) - value);
  }

  public void reduceCash(Player player, double value) {
    this.getBank(player)
        .setCash(this.getCash(player) - value);
  }

  public void reduceMobCoins(Player player, double value) {
    this.getBank(player)
        .setMobCoins(this.getMobCoins(player) - value);
  }

  public void reduceShards(Player player, double value) {
    this.getBank(player)
        .setShards(this.getShards(player) - value);
  }

  public Calistis getCore() {
    return core;
  }

  public Map<UUID, BankAccount> getBanks() {
    return bankAccounts;
  }

}
