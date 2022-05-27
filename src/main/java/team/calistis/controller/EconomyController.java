/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Constanze All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package team.calistis.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.nukkit.Player;
import lombok.Getter;
import team.calistis.Calistis;
import team.calistis.economy.EconomyAccount;

@Getter
public class EconomyController {

  private final Calistis calistis;
  private final Map<UUID, EconomyAccount> economyAccounts;

  public EconomyController(Calistis calistis) {
    this.calistis = calistis;
    this.economyAccounts = new HashMap<>();
  }

  public boolean hasEconomyAccount(Player player) {
    return this.economyAccounts.containsKey(player.getUniqueId());
  }

  public EconomyAccount getEconomyAccountFrom(Player player) {
    return this.economyAccounts.get(player.getUniqueId());
  }

  public EconomyAccount createEconomyAccount(Player player, EconomyAccount economyAccount) {
    return this.economyAccounts.put(player.getUniqueId(), economyAccount);
  }

  public boolean hasEnoughMoney(Player player, double amountToCheck) {
    return this.getEconomyAccountFrom(player)
      .getCurrentMoney() >= amountToCheck;
  }

  public boolean hasEnoughCash(Player player, double amountToCheck) {
    return this.getEconomyAccountFrom(player)
      .getCurrentCash() >= amountToCheck;
  }

  public double getMoneyFrom(Player player) {
    return this.getEconomyAccountFrom(player)
      .getCurrentMoney();
  }

  public double getCashFrom(Player player) {
    return this.getEconomyAccountFrom(player)
      .getCurrentCash();
  }

  public void increaseMoneyTo(Player player, double value) {
    this.getEconomyAccountFrom(player)
      .setCurrentMoney(this.getEconomyAccountFrom(player)
          .getCurrentMoney() + value);
  }

  public void increaseCashTo(Player player, double value) {
    this.getEconomyAccountFrom(player)
      .setCurrentCash(this.getEconomyAccountFrom(player)
          .getCurrentCash() + value);
  }

  public void decreaseMoneyFrom(Player player, double value) {
    this.getEconomyAccountFrom(player)
      .setCurrentMoney(this.getEconomyAccountFrom(player)
          .getCurrentMoney() - value);
  }

  public void decreaseCashFrom(Player player, double value) {
    this.getEconomyAccountFrom(player)
      .setCurrentCash(this.getEconomyAccountFrom(player)
          .getCurrentCash() - value);
  }

  public void setMoneyTo(Player player, double value) {
    this.getEconomyAccountFrom(player).setCurrentMoney(value);
  }

  public void setCashTo(Player player, double value) {
    this.getEconomyAccountFrom(player).setCurrentMoney(value);
  }

}
