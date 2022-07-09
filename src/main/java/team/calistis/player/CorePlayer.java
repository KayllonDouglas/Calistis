package team.calistis.player;

import cn.nukkit.Player;
import cn.nukkit.network.SourceInterface;
import team.calistis.faction.Faction;
import team.calistis.faction.FactionRole;

import java.net.InetSocketAddress;

public class CorePlayer extends Player {

  private Faction faction;
  private FactionRole factionRole;

  private double money, cash;

  public CorePlayer(
          SourceInterface sourceInterface,
          Long clientId,
          InetSocketAddress socketAddress) {
    super(
            sourceInterface,
            clientId,
            socketAddress);
  }

  public void load() {
  }

  public void register() {
  }

  public Faction getFaction() {
    return faction;
  }

  public void setFaction(Faction faction) {
    this.faction = faction;
  }

  public boolean hasFaction() {
    return this.faction != null;
  }

  public FactionRole getFactionRole() {
    return factionRole;
  }

  public void setFactionRole(FactionRole factionRole) {
    this.factionRole = factionRole;
  }

  public boolean hasFactionRole() {
    return this.factionRole != null;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  public boolean hasEnoughMoney(double value) {
    return this.money >= value;
  }

  public double getCash() {
    return cash;
  }

  public void setCash(double cash) {
    this.cash = cash;
  }

  public boolean hasEnoughCash(double value) {
    return this.cash >= value;
  }

}
